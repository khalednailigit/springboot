package com.funsoft.cabinet.controller;

import com.funsoft.cabinet.Service.Etudiant_Service;
import com.funsoft.cabinet.Service.Etudiant_serviceImp;
import com.funsoft.cabinet.model.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class controller {
    @Autowired
    Etudiant_Service etudiant_Service  ;

    @GetMapping("/test")
    public Etudiant test(){
        for(int i = 0 ; i<10; i++){
            Etudiant e1 = new Etudiant();
            e1.setFirstname("khaled".concat(String.valueOf(i)));
            e1.setLastname("naili".concat(String.valueOf(i)));
            etudiant_Service.add_entity(e1);
        }
        Etudiant e1 = new Etudiant();
        e1.setFirstname("khaled");
        e1.setLastname("naili");
        return etudiant_Service.add_entity(e1);

    }
    @GetMapping("/users")
    public List<Etudiant> getAllUsers() {
        return etudiant_Service.findAll();
    }

    @GetMapping("/findUser")
    public List<Etudiant> findUser() {
        return etudiant_Service.find_entity("khaled3");
    }
    @RequestMapping(value = "/finduserby",method = RequestMethod.GET)
    public ModelAndView finduserby() {
        List<Etudiant> lst = etudiant_Service.findAll();
        ModelAndView model = new ModelAndView();
        model.addObject("users",lst);
        model.setViewName("mes_user");
        return model;

    }

}
