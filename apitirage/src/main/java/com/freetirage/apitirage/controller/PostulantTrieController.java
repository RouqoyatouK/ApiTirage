package com.freetirage.apitirage.controller;


import com.freetirage.apitirage.model.PostulantTrie;
import com.freetirage.apitirage.model.Tirage;
import com.freetirage.apitirage.repository.PostulantTrieRepo;
import com.freetirage.apitirage.repository.TirageRepo;
import com.freetirage.apitirage.service.PostulantTrieService;
import com.freetirage.apitirage.service.TirageService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
@RequestMapping("/postulantTrie")
public class PostulantTrieController {

    @Autowired
    private final PostulantTrieService postulantTrieService;
    @Autowired
    TirageService tirageservice;
    @Autowired
    PostulantTrieRepo postulanttrirepo;

    //methode permettant de créer un postulant trié dans la table postulant trié
    public int create(Long idpostulant, String nompostulant, String prenompostulant, String numeropostulant, String email, Long idtirage_id){

        return postulantTrieService.creer(idpostulant, nompostulant, prenompostulant,numeropostulant, email,idtirage_id);
    }



    //requette permettant de retourner les postulants triés lors d'un
    @GetMapping("/{idtirage}")
    public List<PostulantTrie> Afficher(@PathVariable Long idtirage){
        return postulanttrirepo.FINDALLPOSTULANTTRIEPARID(idtirage);
    }


    //retourne le nombre de postulant trier sur une liste
    @GetMapping("/nbrTrier/{id}")
    public  int NombreDePersonneTrier(@PathVariable Long id){
        return postulanttrirepo.LeNombreDePostulantTrier(id);
    }

}
