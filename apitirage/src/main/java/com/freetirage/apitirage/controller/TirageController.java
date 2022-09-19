package com.freetirage.apitirage.controller;


import com.freetirage.apitirage.model.Liste;
import com.freetirage.apitirage.model.Postulant;
import com.freetirage.apitirage.model.PostulantTrie;
import com.freetirage.apitirage.model.Tirage;
import com.freetirage.apitirage.repository.TirageRepo;
import com.freetirage.apitirage.service.ListeService;
import com.freetirage.apitirage.service.PostulantService;
import com.freetirage.apitirage.service.PostulantTrieService;
import com.freetirage.apitirage.service.TirageService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/tirage")
@AllArgsConstructor
public class TirageController {

    @Autowired
    TirageService tirageService;
    @Autowired
     ListeService listeService;
    @Autowired
     PostulantService postulantService;
    @Autowired
     PostulantTrieService postulantTrieService;
    @Autowired
    TirageRepo tirageRepo;



/*fficher toute les information d'une liste
     @GetMapping("/{idliste}")
     public List<Liste> AfficherLibelle( @PathVariable long idliste){

         return listeService.trouverListeParId(idliste);
     }*/

     //Afficher tout les tirage d'une liste

    @GetMapping("tt/{idliste}")
    public List<Tirage> trouverTiragesParIdListe(@PathVariable long idliste){
         return tirageRepo.FindTirageByListId(idliste);
    }


    //Afficher les details d'un tirgae
    @GetMapping("/{idtirage}")
    public Tirage detailDunTirage(@PathVariable Long idtirage){
        return tirageService.AfficherUnTirage(idtirage);
    }

    //Afficher le nombre total de tirage sur une liste
    @GetMapping("/nbr/{idliste}")
    public int NombreTirageUneListe(@PathVariable Long idliste){
        return tirageRepo.LeNombreDeTirage(idliste);
    }





    @PostMapping("/createTirage/{libele}/{nbre}")
    public List<PostulantTrie> create(@RequestBody Tirage tirage, @PathVariable ("libele") String libele, @PathVariable Long nbre) {

        if (tirageService.trouverTirageParLibelle(tirage.getLibelle()) == null) {//verifie si le tirage existe déjà

            //recuperation de la liste demandée par user
            Liste liste = listeService.trouverListeParLibelle(libele);

            Long idliste = liste.getIdliste();//identifiant de la liste entrée par l'user

            //retourne tous les postulants d'une liste donnée
            List<Postulant> postuL = postulantService.TrouveridPostList(idliste);

            //on crée le tirage et recuperer le tirage crée dans l'objet de type tirage tt
            Tirage tt = tirageService.creer(tirage, liste);

            List<Postulant> lp = tirageService.trie(postuL, nbre);//recuperation des postulant trié dans lp

            //recuperation de l'id du tirage
            long idTirage = tt.getId();

            //dans for dessous on parcours et enregistre la liste trié dans la table postulant trié
            for (Postulant p : lp) {//parcours de la liste postulants trié

                //enregistrement de la liste triée
                postulantTrieService.creer(p.getIdpostulant(), p.getNom(), p.getPrenom(), p.getNumero(), p.getEmail(), idTirage);
            }

            //retourne les postulant triés
            return postulantTrieService.trouverPostulantTrieParIdtirage(idTirage);
        } else {
            return null;
        }
    }

}
