package com.csw.xuxianArticle.service;

import com.csw.xuxianArticle.entity.Article;

public interface ArticleService {
    //查询文章
    Article getArticleById(String id);

    //修改文章
    Article updateArticle(Article article);

    //删除文章
    void deleteArticle(String id);

    //点赞
    int giveLike(String userId, String articleId);
}
