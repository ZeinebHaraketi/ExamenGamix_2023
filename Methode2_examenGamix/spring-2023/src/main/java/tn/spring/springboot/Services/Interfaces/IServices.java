package tn.spring.springboot.Services.Interfaces;


import tn.spring.springboot.entities.Client;
import tn.spring.springboot.entities.Cuisinier;
import tn.spring.springboot.entities.Plat;

import java.util.List;

public interface IServices {

public Client ajouterClient(Client client) ;
public void ajouterCuisinier(Cuisinier cuisinier) ;
public void ajouterPlatAffecterClientEtCuisinier(Plat plat , Integer idClient , Integer idCuisinier ) ;
public List<Plat> AfficherListePlatsParClient(String nom , String prenom) ;
public float MontantApayerParClient(Integer idClient) ;
public void AfficherListeCuisinier() ;
public void ModifierImc(Integer idClient) ;

}
