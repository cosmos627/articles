package com.my.articles.controller;

import com.my.articles.dto.ArticleDTO;
import com.my.articles.entity.Article;
import com.my.articles.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("articles")
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @GetMapping("")
    public String showAllArticles(Model model) {
        List<ArticleDTO> dtoList = articleService.getAllArticle();
        model.addAttribute("articles",dtoList);
        return "/articles/show_all";
    }

    @GetMapping("new")
    public String newArticle() {
        return "/articles/new";
    }

    @PostMapping("create")
    public String createArticle(@RequestParam("title")String title,
                                      @RequestParam("content")String content,
                                      Model model) {



        return "redirect:articles";
    }

    @GetMapping("{id}")
    public String showOneArticle(@PathVariable("id") Long id,
                                 Model model) {
        ArticleDTO dto = articleService.getOneArticle(id);
        model.addAttribute("dto", dto);
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
