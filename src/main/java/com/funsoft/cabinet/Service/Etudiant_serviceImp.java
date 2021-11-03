package com.funsoft.cabinet.Service;

import com.funsoft.cabinet.model.Etudiant;
import com.funsoft.cabinet.repository.Etudiant_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
