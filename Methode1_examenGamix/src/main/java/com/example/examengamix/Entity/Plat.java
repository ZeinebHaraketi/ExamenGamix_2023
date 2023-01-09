package com.example.examengamix.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table( name="Plat") //Hné tet7at esm el table mte3ek ====> esm el classe
@Getter
@Setter
@NoArgsConstructor
@ToString
//@EqualsAndHashCode
@AllArgsConstructor
public class Plat implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idPlat")
    private Integer idPlat;

    private String label;

    private Float prix;

    private Float calories;

    @Column(name = "categorie")
    @Enumerated(EnumType.STRING)
    Categorie categorie;


    @ManyToOne
    Client clients;

    @JsonIgnore
    @ManyToMany
    private Set<Cuisinier> cuisiniers= new HashSet<Cuisinier>();


}
