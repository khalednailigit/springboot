package com.funsoft.cabinet.controller;

import com.funsoft.cabinet.model.Auteur;
import com.funsoft.cabinet.model.Car;
import com.funsoft.cabinet.model.Medecin;
import com.funsoft.cabinet.service.AuteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v0")
public class AuteurRest {
    @Autowired
    AuteurService agent ;

    @PostMapping("/auteur")
    public String addauteur(@RequestBody Auteur a) {
        agent.saveorupdate(a);
        return "sucsess";
    }

    @GetMapping("/auteur")
    public List<Auteur> listAuteur() {
        return agent.consulte();
    }

    @GetMapping("/auteur/{id}")
    public Auteur get_auteur(@PathVariable("id") long id) {
        return agent.getById(id);
    }

    @PutMapping("/auteur/{id}")
    public String update_auteur(@PathVariable("id") long id, @RequestBody Auteur med) {
        Auteur auteur = agent.getById(id);
        auteur.setNom(med.getNom());
        auteur.setPrenom(med.getPrenom());
        auteur.setNationalite(med.getNationalite());

        agent.saveorupdate(auteur);
        return "sucsess";
    }
    @DeleteMapping("/auteur/{id}")
    public String delete_auteur(@PathVariable("id") long id) {
        agent.delete(id);
        return "sucsess";
    }

}
