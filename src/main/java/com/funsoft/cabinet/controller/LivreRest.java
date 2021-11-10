package com.funsoft.cabinet.controller;
import com.funsoft.cabinet.Service.ClientService;
import com.funsoft.cabinet.Service.Livre_Service;
import com.funsoft.cabinet.model.Client;
import com.funsoft.cabinet.model.Livre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@RestController
public class LivreRest {

    @Autowired
    Livre_Service agent;

    @RequestMapping(value = "/livres/add", method = RequestMethod.GET)
    public ModelAndView form_add_client() {
        ModelAndView model = new ModelAndView();
        Livre l = new Livre();
        model.addObject("formLivre", l);
        model.setViewName("add_livre");
        return model;
    }

    @RequestMapping(value = "/livres/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("formLivre") Livre livre) {

        agent.saveorupdate(livre);
        return new ModelAndView("redirect:/livres/list");
    }

    @RequestMapping(value = "/livres/list", method = RequestMethod.GET)
    public ModelAndView listlivre(@ModelAttribute("formClient") Livre client) {
        List<Livre> livres = agent.consulte();
        ModelAndView model = new ModelAndView();
        model.addObject("livres",livres );
        model.setViewName("mes_livre");
        return model;
    }
    @RequestMapping(value = "/livres/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") long id) {
        agent.delete(id);
        return new ModelAndView("redirect:/livres/list");

    }
}
