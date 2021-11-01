package com.funsoft.cabinet.controller;

import com.funsoft.cabinet.Service.Etudiant_Service;
import com.funsoft.cabinet.Service.Etudiant_serviceImp;
import com.funsoft.cabinet.model.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class controller {
    @Autowired
    Etudiant_Service agent  ;

    @GetMapping("/test")
    public Etudiant test(){
        Etudiant e1 = new Etudiant();
        e1.setFirstname("khaled");
        e1.setLastname("naili");
        Etudiant_serviceImp serviceImp = new Etudiant_serviceImp();
        return agent.add_entity(e1);
    }
    @GetMapping("/users")
    public List<Etudiant> getAllUsers() {
        return agent.findAll();
    }


}
