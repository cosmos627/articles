package com.my.articles.dao;

import com.my.articles.entity.Article;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ArticleDAOImpl implements ArticleDAO {
    @Autowired
    private EntityManager em;

    @Override
    public Article insertArticle(String title, String content) {
        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);

        em.persist(article);

        return em.find(Article.class, article.getId());
    }
}
