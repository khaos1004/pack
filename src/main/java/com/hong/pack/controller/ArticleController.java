package com.hong.pack.controller;

import com.hong.pack.dto.ArticlesDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {
    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";
    }

    @PostMapping("articles/create")
    public String createArticle(ArticlesDto articlesDto){
        System.out.println(articlesDto.toString());
        return "";
    }
}
