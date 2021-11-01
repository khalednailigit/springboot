package com.funsoft.cabinet.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "correction")
public class Correction_TP_Formation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String correction;

    @ManyToOne
    @JoinColumn(name = "id_tp",referencedColumnName = "id")
    private TP_Formation tp_formation;
}
