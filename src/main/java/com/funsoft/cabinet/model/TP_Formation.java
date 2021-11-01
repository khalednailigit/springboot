package com.funsoft.cabinet.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tps")
public class TP_Formation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    private String file;
    private String sujet;

    @OneToMany(mappedBy = "tp_formation",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Correction_TP_Formation> corrections;
}
