package com.example.examengamix.Repository;

import com.example.examengamix.Entity.Cuisinier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuisinierRepo extends JpaRepository<Cuisinier,Integer> {

    /*@Query("SELECT e FROM Entreprise e WHERE e.adresse =:adresse")
List<Entreprise> retrieveEntreprisesByAdresse(@Param("adresse") String adresse);*/


}
