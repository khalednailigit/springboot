package com.funsoft.cabinet.service;

import com.funsoft.cabinet.model.Article;

import java.util.List;

public interface ArticleService {
    public void saveorupdate(Article c);
    public Article getById(long idc);
    public void delete(long idc);
    public List<Article> consulte();
}
