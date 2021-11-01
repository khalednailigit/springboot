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
    Etudiant_Repository agent ;

    @Override
    public Etudiant add_entity(Etudiant e) {
        return agent.save(e);
    }

    @Override
    public Optional<Etudiant> find_entity(long id) {
        return Optional.empty();
    }

    @Override
    public List<Etudiant> findAll() {
       return agent.findAll();
    }
}
