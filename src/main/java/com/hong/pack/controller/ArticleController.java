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

import java.util.List;
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
//        Optional<Article> articleEntity = articleRepository.findById(id);
        Article articledata = articleRepository.findById(id).orElse(null);// 값이없으면 null값 반환

        //2. 가져온 데이터를 모델에 등록
        model.addAttribute("article", articledata);

        //3. 데이터를 페이지에 보여줌
        return "articles/show";
    }


    @PostMapping("articles/create")
    public String createArticle(ArticlesDto articlesDto){
        log.info(articlesDto.toString());

        //1. Dto를 변환! 엔티티
        Article articles = articlesDto.toEntity();
        log.info(articles.toString());

        //2. Repository에게 엔티티를 DB안에 저장하게 함
        Article saved = articleRepository.save(articles);
        log.info(saved.toString());

        return "redirect:/articles/" + saved.getId();
    }
    @GetMapping("/articles")
    public String index( Model model){
        //1. 모든 Article을 가져온다
//        아래처럼 하면 에러가 방생한다 에러내용 :
//        Required type:
//        List <Article>
//        Provided: Iterable <Article>
//        List<Article> articleEntityList = articleRepository.findAll();
//        아래는 해결할수있는 2가지 방법이다
//        1. 캐스팅을해준다(List<Article>
//         <Article> articleEntityList = (List<Article>articleRepository.findAll();
//        2. Iterable<Articel> articleEntityList = articleRepository.findAll();
//        3. 리포지토리에서 오버라이딩해서 해결
        List<Article> articleEntityList = articleRepository.findAll();

        //2. 가져온 Article묶을을 뷰로 전달
        model.addAttribute("articleList", articleEntityList);

        //3. 뷰페이지를 설정
        return "articles/index";
    }
}
