package com.freetirage.apitirage.controller;

import com.freetirage.apitirage.model.Liste;
import com.freetirage.apitirage.repository.ListeRepo;
import com.freetirage.apitirage.service.ListeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/liste")
@CrossOrigin(origins = "*")
public class ListeController {

    @Autowired
    ListeService listeservice;
    @Autowired
    ListeRepo listerepo;
    /*ListeService listeservice;

    //methode permettant de créer une liste
    @PostMapping("/create")
    public Liste(@RequestBody  Liste liste){//prend une liste en format Json
        return listeservice.creer(liste);//creation de la liste
    }*/

    //afficher toute la liste
    @GetMapping("/afficher")
    public List<Liste> lire(){
        return listeservice.afficher();
    }

    //afficher une liste en fonction de son id
    @GetMapping("/{idliste}")
    public Liste AfficherUneSeule(@PathVariable Long idliste){
        return listeservice.AfficherUNEListe(idliste);
    }


}
