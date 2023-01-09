package tn.spring.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import tn.spring.springboot.entities.Categorie;
import tn.spring.springboot.entities.Client;
import tn.spring.springboot.entities.Cuisinier;

import java.util.List;


@EnableJpaRepositories
public interface CuisinierRepository extends JpaRepository<Cuisinier,Integer> {


    public List<Cuisinier> findAllByPlatsCategorie(Categorie plats_categorie)  ;





}
