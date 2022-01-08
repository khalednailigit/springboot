package com.funsoft.cabinet.service;

import com.funsoft.cabinet.model.Auteur;
import com.funsoft.cabinet.model.Client;
import com.funsoft.cabinet.repository.AuteurRepository;
import com.funsoft.cabinet.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuteurServiceImp implements AuteurService{
    @Autowired
    AuteurRepository agent;
    @Override
    public void saveorupdate(Auteur c) {
        agent.save(c);
    }

    @Override
    public Auteur getById(long idc) {
        return agent.findById(idc).get();
    }

    @Override
    public void delete(long idc) {
        agent.deleteById(idc);
    }

    @Override
    public List<Auteur> consulte() {
        return (List<Auteur>) agent.findAll();
    }


}
