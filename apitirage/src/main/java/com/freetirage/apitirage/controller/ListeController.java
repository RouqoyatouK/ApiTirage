package com.freetirage.apitirage.controller;

import com.freetirage.apitirage.model.Liste;
import com.freetirage.apitirage.service.ListeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/liste")

public class ListeController {

    @Autowired
    ListeService listeservice;
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


}
