package com.hong.pack.dto;

import com.hong.pack.entity.Article;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
@ToString
@NoArgsConstructor
@Setter
@Getter
public class ArticlesDto {
    private String title;
    private String content;

    public Article toEntity() {
        return new Article(null, title, content);
    }
}
