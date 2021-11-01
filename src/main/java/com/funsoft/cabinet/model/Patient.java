package com.funsoft.cabinet.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
//POJO --> Entity using JPA
@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // auto-increment
    private long id;
    @Column(name = "firstname_patient",nullable = false,length = 30)
    private String firstname;
    @Column(name = "lastname_patient",nullable = false,length = 30)
    private String lastname;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String phone;
    @Transient
    private int age;

    @Enumerated(EnumType.STRING)
    private Gender gender;

 //   @OneToMany(mappedBy = "patient")
 //   Set<Rendezvous> Rendezvous;

}
