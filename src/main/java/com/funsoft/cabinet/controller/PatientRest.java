package com.funsoft.cabinet.controller;

import com.funsoft.cabinet.Service.ClientService;
import com.funsoft.cabinet.model.Client;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class PatientRest {
    @Autowired
    ClientService agent;


    @RequestMapping(value = "/clients/add", method = RequestMethod.GET)
    public ModelAndView form_add_client() {
        ModelAndView model = new ModelAndView();
        Client c = new Client();
        model.addObject("formClient", c);
        model.setViewName("add_client");
        return model;
    }

    @RequestMapping(value = "/clients/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("formClient") Client client) {

        agent.saveorupdate(client);
        return new ModelAndView("redirect:/clients/list");
    }

    @RequestMapping(value = "/clients/list", method = RequestMethod.GET)
    public ModelAndView listclient(@ModelAttribute("formClient") Client client) {
        List<Client> clients = agent.consulte();
        ModelAndView model = new ModelAndView();
        model.addObject("clients", clients);
        model.setViewName("mes_client");
        return model;
    }
    @RequestMapping(value = "/clients/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") long id) {
        agent.delete(id);
        return new ModelAndView("redirect:/clients/list");

    }
}
