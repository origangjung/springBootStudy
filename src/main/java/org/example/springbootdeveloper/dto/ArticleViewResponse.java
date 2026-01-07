package org.example.springbootdeveloper.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.springbootdeveloper.domain.Article;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class ArticleViewResponse {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createAt;

    public ArticleViewResponse(Article article) {
        this.id = article.getId();
        this.content = article.getContent();
        this.title = article.getTitle();
        this.createAt = article.getCreatAt();
    }
}
