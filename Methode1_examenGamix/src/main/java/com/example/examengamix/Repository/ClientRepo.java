package com.example.examengamix.Repository;

import com.example.examengamix.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepo extends JpaRepository<Client,Integer> {
    //Integer findByIdCuisinier(Integer idCuisinier);
    //Integer countByCalories(Plat plat);
    Client getByIdClient(int idClient);

    Client findByNomAndPrenom(String nom, String prenom);



}
