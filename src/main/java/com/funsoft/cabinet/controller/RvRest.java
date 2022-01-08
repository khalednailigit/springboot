package com.funsoft.cabinet.controller;


import com.funsoft.cabinet.model.Client;
import com.funsoft.cabinet.model.Medecin;
import com.funsoft.cabinet.model.Rv;
import com.funsoft.cabinet.repository.RvRepository;
import com.funsoft.cabinet.service.ClientService;
import com.funsoft.cabinet.service.MedecinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("api/api/")
public class RvRest {

    @Autowired
    RvRepository agent;

    @Autowired
    ClientService agentcl;

    @Autowired
    MedecinService agentmed;


    @RequestMapping(value = "rdvs/listJson",method = RequestMethod.GET)
    public ResponseEntity <Iterable<Rv>> liste_rdvjson(){
        return ResponseEntity.ok(agent.findAll());


    }

}
