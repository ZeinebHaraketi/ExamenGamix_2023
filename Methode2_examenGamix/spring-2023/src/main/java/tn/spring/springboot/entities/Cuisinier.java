package tn.spring.springboot.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@ToString
@Data

public class Cuisinier implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter

    private int idCuisisnier;
    private String nom ;
    private String prenom ;

    @ManyToMany( cascade = CascadeType.ALL , mappedBy = "cuisiniers" ,fetch = FetchType.EAGER)
    @JsonIgnore
    @ToString.Exclude
    private List<Plat> plats  ;
/*
    @OneToMany(cascade = CascadeType.ALL, mappedBy="beneficiaire")
    @JsonIgnore
    private List<Assurance> assurances;

*/
    /*
    @ManyToMany( cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Medecin> medecins ;
*/
/*
    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Formation> formations ;
    */

}