package com.hong.pack.dto;

import com.hong.pack.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ArticlesDto {
    private String title;
    private String content;

    public Article toEntity() {
        return new Article(null, title, content);
    }
}
