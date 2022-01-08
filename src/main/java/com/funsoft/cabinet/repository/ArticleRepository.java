package com.funsoft.cabinet.repository;

import com.funsoft.cabinet.model.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article,Long> {
}
