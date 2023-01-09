package tn.spring.springboot.Services.Implementation;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.spring.springboot.Services.Interfaces.IServices;
import tn.spring.springboot.entities.*;
import tn.spring.springboot.repositories.ClientRepository;
import tn.spring.springboot.repositories.CuisinierRepository;
import tn.spring.springboot.repositories.PlatRepository;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
public class ServiceImpl implements IServices {

    @Autowired
    PlatRepository platRepository ;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    CuisinierRepository cuisinierRepository ;


    @Override
    public Client ajouterClient(Client client) {
        log.info("client ajouté ");
        return clientRepository.save(client);
    }

    @Override
    public void ajouterCuisinier(Cuisinier cuisinier) {
        log.info("Cuisinier ajouté ");
        cuisinierRepository.save(cuisinier);
    }

    @Override
    public void ajouterPlatAffecterClientEtCuisinier(Plat plat, Integer idClient, Integer idCuisinier) {

        Client client = clientRepository.findById(idClient).orElse(null);
        Cuisinier cuisinier = cuisinierRepository.findById(idCuisinier).orElse(null);
        if(platRepository.countByClientAndCategorie(client,Categorie.PRINCIPAL)<=2)
        plat.setClient(client);
        List<Cuisinier> cuisinierList = new ArrayList<>() ;
        cuisinierList.add(cuisinier);
        plat.setCuisiniers(cuisinierList);
        log.info(String.valueOf(platRepository.countByClientAndCategorie(client,Categorie.PRINCIPAL)));
        platRepository.save(plat);

    }

    @Override
    public List<Plat> AfficherListePlatsParClient(String nom, String prenom) {
        return platRepository.findAllByClientNomAndClientPrenom(nom, prenom);
    }

    @Override
    public float MontantApayerParClient(Integer idClient) {


        Client client = clientRepository.findById(idClient).orElse(null);
        float montant = 0 ;
        List<Plat> plats = platRepository.findAllByClientNomAndClientPrenom(client.getNom() , client.getPrenom()) ;
        for (int i=0 ; i<plats.size() ; i++) {
            montant+=plats.get(i).getPrix();
        }
        return montant;
    }

    @Override
    @Scheduled(fixedRate = 15000)
    public void AfficherListeCuisinier() {

        List<Cuisinier> cuisinierList = cuisinierRepository.findAllByPlatsCategorie(Categorie.PRINCIPAL);
        List<Plat> platList = new ArrayList<>();
        List<Cuisinier> cuisinierList1toShow = new ArrayList<>();

log.info("liste des cuisinier ayant prepare au min deux plats de categorie PRINCIPAL: ");
        for (int i = 0; i < cuisinierList.size(); i++) {
            if (cuisinierList.get(i).getPlats().size() >= 2) {
                if(!cuisinierList1toShow.contains(cuisinierList.get(i)))
                cuisinierList1toShow.add(cuisinierList.get(i));
            }
        }


        for (int i = 0; i < cuisinierList1toShow.size(); i++) {


        try {
            log.info(" nom du cuisinier : " + cuisinierList1toShow.get(i).getNom() + "prenom du cuisnier : " + cuisinierList1toShow.get(i).getPrenom() + "total de ses plats " + cuisinierList1toShow.get(i).getPlats().size());
        } catch (Exception e) {

                 }

        }

    }

    @Override
    public void ModifierImc(Integer idClient) {
        Client client = clientRepository.findById(idClient).orElse(null);
        List<Plat> plats = platRepository.findAllByClientNomAndClientPrenom(client.getNom() , client.getPrenom()) ;
        float sumCalories = 0 ;
        for (int i = 0 ; i< plats.size()  ; i++)  {
            sumCalories+= plats.get(i).getCalories() ;
        }
        if(sumCalories < 2000) {
            client.setImc(Imc.FAIBLE);
        }
        else if (sumCalories == 2000) {
            client.setImc(Imc.IDEAL);

        }
        else if (sumCalories > 2000) {
            client.setImc(Imc.FORT);

        }

        clientRepository.save(client);
log.info("imc est modifié " + sumCalories/plats.size());
    }
}
