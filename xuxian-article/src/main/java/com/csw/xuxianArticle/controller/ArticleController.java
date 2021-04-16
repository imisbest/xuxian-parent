package com.csw.xuxianArticle.controller;

import com.csw.xuxianArticle.entity.Article;
import com.csw.xuxianArticle.feign.LabelClient;
import com.csw.xuxianArticle.service.ArticleService;
import com.csw.xuxianCommon2.entity.Result;
import com.csw.xuxianCommon2.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private LabelClient labelClient;

    /* @PostMapping("addArticle")
     public Result addArticle(@RequestBody Article article) {
         return new Result(true, StatusCode.OK,articleService.)
     }*/
    @GetMapping("getArticleById/{id}")
    public Result getArticleById(@PathVariable("id") String id) {
        return new Result(true, StatusCode.OK, "新增文章成功", articleService.getArticleById(id));
    }

    @PutMapping("updateArticle")
    public Result updateArticle(@RequestBody Article article) {
        return new Result(true, StatusCode.OK, "更新文章成功", articleService.updateArticle(article));
    }

    @DeleteMapping("deleteArticleById/{id}")
    public Result deleteArticleById(@PathVariable("id") String id) {
        articleService.deleteArticle(id);
        return new Result(true, StatusCode.OK, "删除成功", null);
    }

    @GetMapping("giveLike/{userId}/{articleId}")
    public Result giveLike(@PathVariable("userId") String userId,
                           @PathVariable("articleId") String articleId) {
        int i = articleService.giveLike(userId, articleId);
        if (i == -1) {
            return new Result(false, StatusCode.ERROR, "重复点赞", null);
        } else {
            return new Result(true, StatusCode.OK, "成功点赞，不能再次点赞", null);
        }
    }

    @GetMapping("label-base/{id}")
    public Result findLabelByArticleId(@PathVariable("id") String id) {
        return labelClient.findLabelById(id);
    }
}
