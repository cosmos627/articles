package com.my.articles.dao;

import com.my.articles.entity.Article;

public interface ArticleDAO {
    Article insertArticle(String title, String content);
}
