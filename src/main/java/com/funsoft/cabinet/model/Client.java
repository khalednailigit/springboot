package com.funsoft.cabinet.model;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name="clients") // pour renomer la table
public class Client {
    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.AUTO) // auto-increment
    private long id;

    @Column(name = "nom_client") // pour modifier le nom de la colonne de la table
    private String nom;

    @Column(name = "prenom_client")
    private String prenom;

    public Client() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Rv> rdvs;

    public List<Rv> getRdvs() {
        return rdvs;
    }

    public void setRdvs(List<Rv> rdvs) {
        this.rdvs = rdvs;
    }
}
