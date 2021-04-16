package com.csw.xuxianArticle.service.impl;

import com.csw.xuxianArticle.dao.ArticleDao;
import com.csw.xuxianArticle.entity.Article;
import com.csw.xuxianArticle.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Article getArticleById(String id) {
        //数据库查询有没有
        Article article = (Article) redisTemplate.opsForValue().get("article_" + id);
        //如果没有就从数据库查找
        if (article == null) {
            article = articleDao.findById(id).get();
            //查到之后，重新存到redis
            redisTemplate.opsForValue().set("article_" + id, article);

        }
        return article;
    }

    @Override
    public Article updateArticle(Article article) {
        //删除redis缓存中的数据
        redisTemplate.delete("article_" + article.getId());
        //更新数据库
        articleDao.save(article);
        return article;
    }

    @Override
    public void deleteArticle(String id) {
        //删除redis中的相应数据
        redisTemplate.delete("article_" + id);
        //删除数据库中的数据
        articleDao.deleteById(id);
    }

    @Override
    public int giveLike(String userId, String articleId) {
        int result = -1;//表示重复点赞
        //从redis数据库中查
        String flag = (String) redisTemplate.opsForValue().get("thumbsUp_" + userId + "_" + articleId);
        //如果查不到就，
        if (flag == null) {
            //自定义更新数据库
            articleDao.updateThumbsUp(articleId);
            //加入redis
            redisTemplate.opsForValue().set("thumbsUp_" + userId + "_" + articleId, "点赞", 1, TimeUnit.MINUTES);
            //将放回结果置为1
            result = 1;
        }
        return result;
    }
}
