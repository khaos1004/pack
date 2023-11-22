package com.hong.pack.controller;

import com.hong.pack.dto.ArticlesDto;
import com.hong.pack.entity.Article;
import com.hong.pack.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;
    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";
    }

    @PostMapping("articles/create")
    public String createArticle(ArticlesDto articlesDto){

        System.out.println(articlesDto.toString());

        //1. Dto를 변환! 엔티티
        Article articles = articlesDto.toEntity();
        System.out.println(articles.toString());

        //2. Repository에게 엔티티를 DB안에 저장하게 함
        Article saved = articleRepository.save(articles);
        System.out.println(saved.toString());
        return "";
    }
}
