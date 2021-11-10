package com.funsoft.cabinet.repository;
import com.funsoft.cabinet.model.Etudiant;
import com.funsoft.cabinet.model.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LivreRepository  extends JpaRepository<Livre,Long> {
}
