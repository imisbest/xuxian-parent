package com.csw.xuxianArticle.dao;

import com.csw.xuxianArticle.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ArticleDao extends JpaRepository<Article, String>, JpaSpecificationExecutor<Article> {
    //点赞
    @Transactional
    @Modifying
    @Query(value = "update tb_article set thumbs_up = thumbs_up+1 where id = ?", nativeQuery = true)
    void updateThumbsUp(String id);
}
