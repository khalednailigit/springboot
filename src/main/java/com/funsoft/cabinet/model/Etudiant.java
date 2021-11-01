package com.funsoft.cabinet.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "etudiants")
@EntityListeners(AuditingEntityListener.class)

public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "firstname", nullable = true, length = 255)
    private String firstname;

    @Column(name = "lastname", nullable = true, length = 255)
    private String lastname;

    @Column(name = "age", nullable = true)
    private long age ;

}
