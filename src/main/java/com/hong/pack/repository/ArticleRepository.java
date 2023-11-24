package com.hong.pack.repository;

import com.hong.pack.entity.Article;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository
public interface ArticleRepository extends CrudRepository<Article, Long> {

}