package com.freetirage.apitirage.service;


import com.freetirage.apitirage.model.PostulantTrie;
import com.freetirage.apitirage.repository.PostulantTrieRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PostulantTrieServiceImpl implements PostulantTrieService{


    @Autowired
     PostulantTrieRepo postulantTrieRepo;

    //redefinition de la methode permettant de creer les postulant trié
    @Override
    public int creer(Long idpostulant, String nompostulant, String prenompostulant, String numeropostulant, String email, Long idtirage_id) {

        //creation des postulant trié
        return postulantTrieRepo.INSERTPOSTTIRE(idpostulant,nompostulant, prenompostulant, numeropostulant, email, idtirage_id);
    }

    //redefinition de la methode qui retourne les postulant trié d'un tirage
    @Override
    public List<PostulantTrie> trouverPostulantTrieParIdtirage(Long idtirage_id) {
        //retour des postulant trié
        return postulantTrieRepo.FINDALLPOSTULANTTRIEPARID(idtirage_id);
    }

    @Override
    public List<Object[]> listepostulant() {
        return postulantTrieRepo.listepostulant();
    }
}
