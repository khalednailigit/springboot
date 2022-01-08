package com.funsoft.cabinet.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;


@Entity
@Table(name = "auteur")
public class Auteur {

    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment
    private long id;

    @NotNull
    @NotBlank
    @NotEmpty
    @Size(min = 3, max = 10, message = "la taille doit être entre 3 et 10")
    @Pattern(regexp = "[a-zA-Z]+", message = "le nom ne doit que des alphabets")
    @Column(name = "nom") // pour modifier le nom de la colonne de la table
    private String nom;

    @NotEmpty
    @Size(min = 3, max = 10, message = "la taille doit être entre 3 et 10")
    @Pattern(regexp = "[a-zA-Z]+", message = "le prenom ne doit que des alphabets")
    @Column(name = "prenom")
    private String prenom;


    @NotEmpty
    @Size(min = 3, max = 10, message = "la taille doit être entre 3 et 10")
    @Pattern(regexp = "[a-zA-Z]+", message = "le prenom ne doit que des alphabets")
    @Column(name = "nationalite")
    private String nationalite;


    @JsonBackReference
    @OneToMany(mappedBy = "auteur",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Article> articles;



    public Auteur() {
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

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
