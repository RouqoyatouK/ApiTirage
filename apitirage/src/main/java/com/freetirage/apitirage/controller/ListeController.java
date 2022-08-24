package com.freetirage.apitirage.controller;

import com.freetirage.apitirage.model.Liste;
import com.freetirage.apitirage.service.ListeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/liste")
public class ListeController {
    ListeService listeservice;

    //methode permettant de créer une liste
    @PostMapping("/create")
    public Liste create(@RequestBody  Liste liste){//prend une liste en format Json
        return listeservice.creer(liste);//creation de la liste
    }


}
