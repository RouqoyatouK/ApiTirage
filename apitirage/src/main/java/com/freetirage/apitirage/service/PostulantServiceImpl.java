package com.freetirage.apitirage.service;


import com.freetirage.apitirage.model.Postulant;
import com.freetirage.apitirage.repository.PostulantRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PostulantServiceImpl implements PostulantService {

    @Autowired
    PostulantRepo postualntrepo;

    //redefinition de la methode d'enregistrement des postulant
    @Override
    public List<Postulant> enregistrer(List<Postulant> listPost) {
        return postualntrepo.saveAll(listPost);
    }
    //redefinition de la methode de recuperation des postulants par l'id de la liste

    //lors du trie lorsque qu'on renseigne le libelle la methode  FINDIDPOSTLIST ira chercher l'id qui correspondd au libelle afin de recuperer tout les postulant
    @Override
    public List<Postulant> TrouveridPostList(long idListe) {

        return postualntrepo.FINDIDPOSTLIST(idListe);
    }
}
