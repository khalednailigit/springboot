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
@Table(name = "rendezvous")
public class Rendezvous {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public double id;

    @Column(name = "jour", nullable = true, length = 255)
    public String jour;



    @ManyToOne
    @JoinColumn(name = "id_doctor",referencedColumnName = "id",insertable = false, updatable = false)
    public Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "id_patient",referencedColumnName = "id",insertable = false, updatable = false)
    public Patient patient;

}
