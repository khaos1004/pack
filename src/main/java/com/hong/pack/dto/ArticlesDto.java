package com.hong.pack.dto;

import com.hong.pack.entity.Article;

public class ArticlesDto {
    private String title;
    private String content;

    @Override
    public String toString() {
        return "ArticlesDto{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public ArticlesDto(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Article toEntity() {
        return new Article(null, title, content);
    }
}
