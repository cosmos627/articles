package com.my.articles.dto;

import com.my.articles.entity.Article;
import com.my.articles.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDTO {
    private Long id;
    private String title;
    private String content;
//    private List<Comment> comments = new ArrayList<>();
    private List<CommentDTO> comments = new ArrayList<>();

    public static ArticleDTO fromArticle(Article article){
        return new ArticleDTO(
                article.getId(),
                article.getTitle(),
                article.getContent(),
                article.getComments()
                        .stream()
                        .map(x->CommentDTO.fromEntity(x))
                        .toList()
//                article.getComments()
        );
    }

    public static Article fromDto(ArticleDTO dto){
        Article article = new Article();
        article.setId(dto.getId());
        article.setTitle(dto.getTitle());
        article.setContent(dto.getContent());
//        article.setComments(dto.getComments());
        return article;
    }
}
