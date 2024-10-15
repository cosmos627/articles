package com.my.articles.service;

import com.my.articles.dao.ArticleDAOImpl;
import com.my.articles.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {
    @Autowired
    ArticleDAOImpl articleDAO;

    public Article createArticle(String title, String content) {
        return articleDAO.insertArticle(title, content);
    }
}
