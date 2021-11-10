package com.funsoft.cabinet.Service;

import com.funsoft.cabinet.model.Client;
import com.funsoft.cabinet.model.Livre;
import com.funsoft.cabinet.repository.ClientRepository;
import com.funsoft.cabinet.repository.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivreServiceImp implements Livre_Service{
    @Autowired
    LivreRepository agent;

    @Override
    public void saveorupdate(Livre l) {
        agent.save(l);
    }

    @Override
    public Livre getById(long id) {
        return agent.findById(id).get();
    }

    @Override
    public void delete(long id) {
        agent.deleteById(id);
    }

    @Override
    public List<Livre> consulte() {
        return (List<Livre>) agent.findAll();
    }
}
