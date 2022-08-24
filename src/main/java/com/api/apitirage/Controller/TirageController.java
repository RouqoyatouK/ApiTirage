package com.api.apitirage.Controller;

import com.api.apitirage.Modele.Liste;
import com.api.apitirage.Modele.Postulant;
import com.api.apitirage.Modele.PostulantTrie;
import com.api.apitirage.Modele.Tirage;
import com.api.apitirage.Service.PostulantTrieService;
import com.api.apitirage.Service.TirageService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tirage")
@AllArgsConstructor
public class TirageController {

    @Autowired
    private final TirageService tirageService;
    //private final ListeService listeService;
   // private final PostulantService postulantService;
    private  final PostulantTrieService postulantTrieService;

    @PostMapping("/createTirage/{libelle_liste}/{nbre}")
    public List<PostulantTrie> create(@RequestBody Tirage tirage, @PathVariable String libelle_liste, @PathVariable Long nbre) {

        if (tirageService.trouverTirageParLibelle(tirage.getLibelle()) == null) {//verifie si le tirage existe déjà

            //recuperation de la liste demandée par user
            Liste liste = listeService.trouverListeParLibelle(libelle_liste);

            Long idliste = liste.getId_liste();//identifiant de la liste entrée par l'user

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
                postulantTrieService.creer(p.getIdPostulant(), p.getNom(), p.getPrenom(), p.getNumero(), p.getEmail(), idTirage);
            }

            //retourne les postulant triés
            return postulantTrieService.trouverPostulantTrieParIdtirage(idTirage);
        } else {
            return null;
        }
    }

}
