package com.freetirage.apitirage.service;


import com.freetirage.apitirage.model.Postulant;
import com.freetirage.apitirage.repository.PostulantRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PostulantServiceImpl implements PostulantService {
    PostulantRepo postualntrepo;

    //redefinition de la methode d'enregistrement des postulant
    @Override
    public List<Postulant> enregistrer(List<Postulant> listPost) {
        return postualntrepo.saveAll(listPost);
    }
    //redefinition de la methode de recuperation des postulants par l'id de la liste
    @Override
    public List<Postulant> TrouveridPostList(long idListe) {

        return postualntrepo.FINDIDPOSTLIST(idListe);
    }
}
