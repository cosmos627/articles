package com.my.articles.service;

import com.my.articles.dao.CommentDAO;
import com.my.articles.dto.CommentDTO;
import com.my.articles.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class CommentService {
    @Autowired
    CommentDAO dao;

//    public CommentDTO getOneComment(Long id) {
//        Comment comment = dao.getOneComment(id);
//        if(ObjectUtils.isEmpty(comment)) return null;
//        return CommentDTO.fromComment(comment);
//    }

    public void updateComment(CommentDTO dto) {
        dao.updateComment(dto);
    }

    public void deleteComment(Long id) {
        dao.deleteComment(id);
    }
}
