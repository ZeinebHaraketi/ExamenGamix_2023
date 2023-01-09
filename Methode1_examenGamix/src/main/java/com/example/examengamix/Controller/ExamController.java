package com.example.examengamix.Controller;

import com.example.examengamix.Entity.Client;
import com.example.examengamix.Entity.Cuisinier;
import com.example.examengamix.Entity.Plat;
import com.example.examengamix.Services.ExamServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("exam")
public class ExamController {

    @Autowired
    ExamServices examServices;


    @PostMapping("/addC")
    @ResponseBody
    public Client ajouterClient(@RequestBody Client client){
        return examServices.ajouterClient(client);
    }

    @PostMapping("/addCu")
    @ResponseBody
    public void ajouterCuisiner(@RequestBody Cuisinier cuisinier){
        examServices.ajouterCuisiner(cuisinier);
    }


    @PostMapping("/ajouterPlatAffecterClientEtCuisiner/{idClient}/{idCuisinier}")
    public void ajouterPlatAffecterClientEtCuisiner(@RequestBody Plat plat, @PathVariable Integer idClient, @PathVariable Integer idCuisinier) {
        examServices.ajouterPlatAffecterClientEtCuisiner(plat,idClient,idCuisinier);
    }

    @GetMapping("/calculerMontant/{idClient}")
    public Float MontantAPayerParClient(@PathVariable ("idClient")int idClient){
        return examServices.MontantAPayerParClient(idClient);
    }

    @GetMapping("/AfficherListePlatsParClient/{nom}/{prenom}")
    public Set<Plat> AfficherListePlatsParClient(@PathVariable("nom")String nom, @PathVariable("prenom") String prenom) {
        return examServices.AfficherListePlatsparClient(nom, prenom);
    }

    @PutMapping("/ModifierImc/{idClient}")
    public void ModifierImc(@PathVariable("idClient") Integer idClient){
        examServices.ModifierImc(idClient);
    }
}
