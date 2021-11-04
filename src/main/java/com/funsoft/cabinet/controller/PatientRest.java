package com.funsoft.cabinet.controller;

import com.funsoft.cabinet.model.Client;
import org.dom4j.rule.Mode;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class PatientRest {

    @RequestMapping(value = "client/add", method = RequestMethod.GET)
    public ModelAndView form_add_client(){
        ModelAndView model = new ModelAndView();
        Client c = new Client();
        model.addObject("formClient",c);
        model.setViewName("add_client");
        return  model;
    }
}
