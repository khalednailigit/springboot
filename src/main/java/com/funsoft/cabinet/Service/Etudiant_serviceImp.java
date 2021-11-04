package com.funsoft.cabinet.Service;

import com.funsoft.cabinet.model.Etudiant;
import com.funsoft.cabinet.repository.Etudiant_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Etudiant_serviceImp implements Etudiant_Service {


    @Autowired
    Etudiant_Repository etudiant_Repository ;

    @Override
    public Etudiant add_entity(Etudiant e) {
        return etudiant_Repository.save(e);
    }



    @Override
    public List<Etudiant> find_entity(String name) {
        return etudiant_Repository.findByFirstname(name);
    }

    @Override
    public List<Etudiant> findAll() {
       return etudiant_Repository.findAll();
    }
}
