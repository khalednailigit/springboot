package com.funsoft.cabinet.repository;

import com.funsoft.cabinet.model.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface Etudiant_Repository extends JpaRepository<Etudiant,Long> {
    public List<Etudiant> findByFirstname(String name);
    public List<Etudiant> findByFirstnameAndLastname(String firstname,String lastname);


}
