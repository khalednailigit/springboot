package com.funsoft.cabinet.service;

import com.funsoft.cabinet.model.Auteur;

import java.util.List;

public interface AuteurService {
    public void saveorupdate(Auteur c);
    public Auteur getById(long idc);
    public void delete(long idc);
    public List<Auteur> consulte();
}
