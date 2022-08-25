package com.freetirage.apitirage.controller;


import com.freetirage.apitirage.service.PostulantTrieService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/postulantTrie")
public class PostulantTrieController {

    @Autowired
    private final PostulantTrieService postulantTrieService;

    //methode permettant de créer un postulant trié dans la table postulant trié
    public int create(Long idpostulant, String nompostulant, String prenompostulant, String numeropostulant, String email, Long idtirage_id){

        return postulantTrieService.creer(idpostulant, nompostulant, prenompostulant,numeropostulant, email,idtirage_id);
    }
}
