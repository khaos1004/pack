package com.hong.pack.controller;

import com.hong.pack.dto.ArticlesDto;
import com.hong.pack.repository.ArticleRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ArticleControllerTest {
    @Autowired
    private ArticleRepository articleRepository;

    @Test
    void newArticleForm() {
    }

    @Test
    void show() {
    }

    @Test
    void createArticle() {
        ArticlesDto data  = new ArticlesDto();
        data.setTitle("fdfda");
        data.setContent("dafdas");
//        articleRepository.save(data);
    }

    @Test
    void index() {
    }
}