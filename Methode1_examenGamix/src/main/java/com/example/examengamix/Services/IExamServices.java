package com.example.examengamix.Services;

import com.example.examengamix.Entity.Client;
import com.example.examengamix.Entity.Cuisinier;
import com.example.examengamix.Entity.Plat;

import java.util.List;
import java.util.Set;

public interface IExamServices {

    public Client ajouterClient(Client client);

    public void ajouterCuisiner(Cuisinier cuisinier);

    public void ajouterPlatAffecterClientEtCuisiner(Plat plat, Integer idClient, Integer idCuisinier);

    public void ModifierImc(Integer idclient);

    public Float MontantAPayerParClient(Integer idClient);

    public Set<Plat> AfficherListePlatsparClient(String nom, String prenom);
    public void AfficherListeCuisinier();

}
