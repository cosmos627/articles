package com.my.articles.controller;

import com.my.articles.entity.Article;
import com.my.articles.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping("articles")
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @GetMapping("")
    public String showAllArticles() {

        return "/articles/show_all";
    }

    @GetMapping("new")
    public String newArticle() {
        return "/articles/new";
    }

    @PostMapping("create")
    public ModelAndView createArticle(@RequestParam("title")String title,
                                      @RequestParam("content")String content,
                                      Model model) {

        Article article = articleService.createArticle(title, content);
        model.addAttribute("article", article);

        return new ModelAndView("redirect:articles");
    }

    @GetMapping("{id}")
    public String showOneArticle(Model model) {
        return "/articles/show";
    }

    @GetMapping("{id}/update")
    public String viewUpdateArticle() {
        return "/articles/update";
    }

    @PostMapping("update")
    public String updateArticle() {
        return "redirect:articles";
    }

    @GetMapping("{id}/delete")
    public String deleteArticle() {
        return "redirect:articles";
    }
}
