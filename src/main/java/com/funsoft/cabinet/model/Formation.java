package com.funsoft.cabinet.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="T_Formation")
public class Formation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FORMATION_ID")
    private long idf;
    private String theme;
}
