package com.funsoft.cabinet.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "doctors")
@EntityListeners(AuditingEntityListener.class)
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    @Column(name = "name", nullable = true, length = 255)
    public String name;

    @Column(name = "specialite", nullable = true, length = 255)
    public String specialite;

  //  @OneToMany(mappedBy = "doctor")
 //   Set<Rendezvous> Rendezvous;
}
