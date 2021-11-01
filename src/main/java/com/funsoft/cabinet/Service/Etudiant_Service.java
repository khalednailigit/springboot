package com.funsoft.cabinet.Service;

import com.funsoft.cabinet.model.Etudiant;

import java.util.List;
import java.util.Optional;

public interface Etudiant_Service {
    public Etudiant add_entity(Etudiant e);
    public Optional<Etudiant> find_entity(long id);
    public List<Etudiant> findAll();

}
