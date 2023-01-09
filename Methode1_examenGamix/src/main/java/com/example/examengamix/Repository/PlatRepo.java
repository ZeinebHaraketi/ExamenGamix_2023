package com.example.examengamix.Repository;

import com.example.examengamix.Entity.Client;
import com.example.examengamix.Entity.Plat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatRepo extends JpaRepository<Plat,Integer> {
    //Plat findByClients(Integer idClient);
    Plat findByClients(Client client);

}
