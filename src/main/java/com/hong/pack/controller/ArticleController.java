package com.hong.pack.controller;

import com.hong.pack.dto.ArticlesDto;
import com.hong.pack.entity.Article;
import com.hong.pack.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
@Slf4j
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;
    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";
    }

    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model){
        log.info("id= " + id);

        //1. id 로 데이터를 가져옴
        Optional<Article> articleEntity = articleRepository.findById(id);
//        Article articledata = articleRepository.findById(id).orElse(null);// 값이없으면 nuul값 반환 위에꺼랑 같음

        //2. 가져온 데이터를 모델에 등록
        model.addAttribute("article", articleEntity);

        //3. 데이터를 페이지에 보여줌


        return "articles/show";
    }


    @PostMapping("articles/create")
//    @Slf4j
    public String createArticle(ArticlesDto articlesDto){
        log.info(articlesDto.toString());

        //1. Dto를 변환! 엔티티
        Article articles = articlesDto.toEntity();
        log.info(articles.toString());

        //2. Repository에게 엔티티를 DB안에 저장하게 함
        Article saved = articleRepository.save(articles);
        log.info(saved.toString());

        return null;
    }
}
