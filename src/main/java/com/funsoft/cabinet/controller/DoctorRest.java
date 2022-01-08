package com.funsoft.cabinet.controller;

import com.funsoft.cabinet.model.Medecin;
import com.funsoft.cabinet.model.Recherche;
import com.funsoft.cabinet.service.MedecinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("api/v0")
public class DoctorRest {

    @Autowired
    MedecinService agent;

    @GetMapping("/medecins")
    public List<Medecin> List_med() {
        return agent.consulte();
    }

    @PostMapping("/medecins")
    public String add_med(@RequestBody Medecin med) {
        agent.saveorupadte(med);
        return "sucsess";
    }

    @GetMapping("/medecin/{id}")
    public Medecin get_med(@PathVariable("id") long id) {
        return agent.getById(id);
    }

    @DeleteMapping("/medecin/{id}")
    public String delete_med(@PathVariable("id") long id) {
        agent.delete(id);
        return "sucsess";
    }

    @PutMapping("/medecin/{id}")
    public String update_med(@PathVariable("id") long id, @RequestBody Medecin med) {
        Medecin medcin = agent.getById(id);
        medcin.setNom(med.getNom());
        medcin.setPrenom(med.getPrenom());

        medcin.setSpecialite(med.getSpecialite());


        agent.saveorupadte(medcin);
        return "sucsess";
    }
}
