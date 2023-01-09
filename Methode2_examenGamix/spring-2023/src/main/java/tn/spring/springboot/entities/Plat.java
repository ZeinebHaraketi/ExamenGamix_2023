package tn.spring.springboot.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@ToString
@Data

public class Plat implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter

    private int idPlat;
    private String label ;
    private float prix ;
    private float calories ;
    @Enumerated(EnumType.STRING)
    private Categorie categorie ;


    @ManyToMany( cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Cuisinier> cuisiniers ;

    @ManyToOne
    @JsonIgnore
    Client client ;
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