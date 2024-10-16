package com.my.articles.controller;

import com.my.articles.dto.ArticleDTO;
import com.my.articles.dto.CommentDTO;
import com.my.articles.entity.Comment;
import com.my.articles.service.CommentService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("comments")
public class CommentController {
    @Autowired
    CommentService commentService;

//    @GetMapping("{id}/update")
//    public String viewUpdateComment(@PathVariable("id")Long id,
//                                    Model model) {
//        CommentDTO dto = commentService.getOneComment(id);
//        model.addAttribute("dto", dto);
//        return "/comments/update";
//    }

    @PostMapping("update")
    public String updateComment(@RequestParam("articleId") Long articleId,
                                CommentDTO dto) {
        String url = "redirect:/articles/"+articleId;
        commentService.updateComment(dto);
        return url;
    }

    @GetMapping("{id}/delete")
    public String deleteComment(@PathVariable("id")Long id,
                                    @RequestParam("article_id")Long article_id) {
        String url = "redirect:/articles/"+article_id;
        commentService.deleteComment(id);
        return url;
    }

    @PostMapping("insert")
    public String insertComment(CommentDTO dto) {
        System.out.println("======================== "+dto.getNickname());
        return "/articles";
    }
}
