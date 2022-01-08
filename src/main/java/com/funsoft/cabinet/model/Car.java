package com.funsoft.cabinet.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name="car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    @NotNull
    @NotBlank
    @NotEmpty
    @Size(min=3,max=10,message = "la taille doit être entre 3 et 10")
    @Pattern(regexp = "[a-zA-Z]+",message="le marque ne doit que des alphabets")
    @Column(name = "marque") // pour modifier le nom de la colonne de la table
    public String marque;

    @NotEmpty
    @Size(min=3,max=10,message = "la taille doit être entre 3 et 10")
    @Pattern(regexp = "[a-zA-Z]+",message="le modele ne doit que des alphabets")
    @Column(name = "modele")
    public String modele ;

    public Car() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }
}
