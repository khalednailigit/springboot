package com.funsoft.cabinet.Service;

import com.funsoft.cabinet.model.Client;
import com.funsoft.cabinet.model.Livre;

import java.util.List;

public interface Livre_Service {
    public void saveorupdate(Livre l);
    public Livre getById(long id);
    public void delete(long id);
    public List<Livre> consulte();
}
