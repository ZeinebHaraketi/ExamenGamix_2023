package com.example.examengamix.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table( name="Cuisinier") //Hné tet7at esm el table mte3ek ====> esm el classe
@Getter
@Setter
@NoArgsConstructor
@ToString
//@EqualsAndHashCode
@AllArgsConstructor
public class Cuisinier implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idCuisinier")
    private Integer idCuisinier;

    private String nom;
    private String prenom;


    @JsonIgnore
    @ManyToMany(mappedBy = "cuisiniers")
    private Set<Plat> plats= new HashSet<Plat>();

}
