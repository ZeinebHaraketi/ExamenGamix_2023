package com.example.examengamix.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table( name="Client") //Hné tet7at esm el table mte3ek ====> esm el classe
@Getter
@Setter
@NoArgsConstructor
@ToString
//@EqualsAndHashCode
@AllArgsConstructor

public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idClient")
    private Integer idClient;

    private String nom;

    private String prenom;

    @Column(name = "imc")
    @Enumerated(EnumType.STRING)
    IMC imc;

    @JsonIgnore
    @OneToMany(mappedBy = "clients")
    private Set<Plat> plats= new HashSet<Plat>();
}
