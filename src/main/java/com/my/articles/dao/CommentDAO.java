package com.my.articles.dao;

import com.my.articles.dto.CommentDTO;
import com.my.articles.entity.Comment;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class CommentDAO {
    @Autowired
    EntityManager em;

    public Comment getOneComment(Long id) {
        return em.find(Comment.class, id);
    }

    public void updateComment(CommentDTO dto) {
        Comment comment = em.find(Comment.class, dto.getId());
        comment.setNickname(dto.getNickname());
        comment.setBody(dto.getBody());
    }

    public void deleteComment(Long id) {
        Comment comment = em.find(Comment.class, id);
        em.remove(comment);
    }
}
