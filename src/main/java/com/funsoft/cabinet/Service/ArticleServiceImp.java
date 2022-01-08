package com.funsoft.cabinet.service;

import com.funsoft.cabinet.model.Article;
import com.funsoft.cabinet.model.Auteur;
import com.funsoft.cabinet.repository.ArticleRepository;
import com.funsoft.cabinet.repository.AuteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ArticleServiceImp implements ArticleService {
    @Autowired
    ArticleRepository agent;
    @Override
    public void saveorupdate(Article c) {
        agent.save(c);
    }

    @Override
    public Article getById(long idc) {
        return agent.findById(idc).get();
    }

    @Override
    public void delete(long idc) {
        agent.deleteById(idc);
    }

    @Override
    public List<Article> consulte() {
       return (List<Article>) agent.findAll();
    }
}
