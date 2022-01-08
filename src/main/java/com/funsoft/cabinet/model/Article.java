package com.funsoft.cabinet.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name="article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @NotBlank
    @NotEmpty
    @Size(min = 3, max = 10, message = "la taille doit être entre 3 et 10")
    @Column(name = "titre") // pour modifier le nom de la colonne de la table
    private String titre;

    @NotNull
    @NotBlank
    @NotEmpty
    @Size(min = 3, max = 10, message = "la taille doit être entre 3 et 10")
    @Column(name = "content") // pour modifier le nom de la colonne de la table
    private String content;



    @JoinColumn(name = "idAuteur",referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Auteur auteur;

    public Article() {
        this.auteur = new Auteur(); // pour avoir de l'espace mémoire (client.id)

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Auteur getAuteur() {
        return auteur;
    }

    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }
}
