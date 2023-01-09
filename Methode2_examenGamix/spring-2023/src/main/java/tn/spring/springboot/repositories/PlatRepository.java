package tn.spring.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import tn.spring.springboot.entities.Categorie;
import tn.spring.springboot.entities.Client;
import tn.spring.springboot.entities.Plat;

import java.util.List;


@EnableJpaRepositories
public interface PlatRepository extends JpaRepository<Plat,Integer> {

    public List<Plat> findAllByClientNomAndClientPrenom(String client_nom, String client_prenom) ;
    public int countByClientAndCategorie(Client client, Categorie categorie);
}
