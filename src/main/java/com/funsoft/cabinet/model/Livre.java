package com.funsoft.cabinet.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="livres")
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // auto-increment
    private long id;
    @Column(name = "titre",nullable = true,length = 30)
    private String titre;
    @Column(name = "auteur",nullable = true,length = 30)
    private String auteur;
    @Column(name = "description",nullable = true,length = 30)
    private String description;
    @Column(name = "mots_cles",nullable = true,length = 30)
    private String mots_cles;
}
