package com.example.examengamix.Services;

import com.example.examengamix.Entity.*;
import com.example.examengamix.Repository.ClientRepo;
import com.example.examengamix.Repository.CuisinierRepo;
import com.example.examengamix.Repository.PlatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
public class ExamServices implements IExamServices{
    @Autowired
    ClientRepo clientRepo;

    @Autowired
    CuisinierRepo cuisinierRepo;

    @Autowired
    PlatRepo platRepo;

    @Override
    public Client ajouterClient(Client client) {
        return clientRepo.save(client);
    }

    @Override
    public void ajouterCuisiner(Cuisinier cuisinier) {
        cuisinierRepo.save(cuisinier);
    }

    @Override
    public void ajouterPlatAffecterClientEtCuisiner(Plat plat, Integer idClient, Integer idCuisinier) {
        plat.setClients(clientRepo.findById(idClient).get());
        Cuisinier c= cuisinierRepo.findById(idCuisinier).get();
        plat.getCuisiniers().add(c);
        platRepo.save(plat);
    }

    @Override
    public void ModifierImc(Integer idclient) {
        Client c= clientRepo.findById(idclient).get();
        Plat p= new Plat();
        for (Plat plat:c.getPlats()
             ) {

            if (calculCalories(plat)<2000){
                c.setImc(IMC.FAIBLE);
            } else if (calculCalories(plat)==2000) {
                c.setImc(IMC.IDEAL);
            } else if (calculCalories(plat)>2000) {
                c.setImc(IMC.FORT);
            }
        }
        clientRepo.save(c);

    }

    @Override
    public Float MontantAPayerParClient(Integer idClient) {
        Float total=0.0f;
        Client c= clientRepo.findById(idClient).get();
        for (Plat plat: c.getPlats()
             ) {
            total += plat.getPrix();
        }

        return total;
    }

    @Override
    @Transactional
    public Set<Plat> AfficherListePlatsparClient(String nom, String prenom){
        Client d= clientRepo.findByNomAndPrenom(nom,prenom);
        return  d.getPlats();
    }


    @Override
    @Scheduled(cron = "*/15 * * * * *")
    public void AfficherListeCuisinier() {
        Plat p= new Plat();
        Integer totalP=0;
        String ch="PRINCIPAL";

        for (Cuisinier cuisinier: cuisinierRepo.findAll()
             ) {
                System.out.println("Le Nom:"+ cuisinier.getNom()+"Le Prenom:"+ cuisinier.getPrenom());

        }
    }


    public Boolean Minimum2Plats(Plat plat){
        Boolean test= false;
        for (Cuisinier c:plat.getCuisiniers()
             ) {
            if (c.getPlats().size()>=2)
                test= true;
            else
                test=false;
        }
        return test;
    }

    public Float calculCalories(Plat plat){
        Float tot=0.0f;

        tot += plat.getCalories();
        return tot;
    }
}
