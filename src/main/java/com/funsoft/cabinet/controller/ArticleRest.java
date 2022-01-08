package com.funsoft.cabinet.controller;

import com.funsoft.cabinet.model.Article;
import com.funsoft.cabinet.model.Client;
import com.funsoft.cabinet.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("api/v0")
public class ArticleRest {
    @Autowired
    ArticleService agent ;

    @PostMapping("/article")
    public String addarticle(@RequestBody Article a) {
        agent.saveorupdate(a);
        return "sucsess";
    }

    @GetMapping("/article")
    public List<Article> listarticle() {
        return agent.consulte();
    }

    @RequestMapping(value = "/article/list",method = RequestMethod.GET)
    public ModelAndView liste_article(){
        List<Article> article = agent.consulte();

        ModelAndView model = new ModelAndView();
        model.addObject("articles",article);
        model.setViewName("listarticle");
        return model;
    }

    @GetMapping("/article/{id}")
    public Article get_article(@PathVariable("id") long id) {
        return agent.getById(id);
    }

    @PutMapping("/article/{id}")
    public String update_article(@PathVariable("id") long id, @RequestBody Article article) {
        Article art  = agent.getById(id);
        art.setTitre(article.getTitre());
        art.setContent(article.getContent());
        agent.saveorupdate(art);
        return "sucsess";
    }
    @DeleteMapping("/article/{id}")
    public String delete_article(@PathVariable("id") long id) {
        agent.delete(id);
        return "sucsess";
    }
}
