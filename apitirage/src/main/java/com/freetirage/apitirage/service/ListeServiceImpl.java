package com.freetirage.apitirage.service;

import com.freetirage.apitirage.model.Liste;
import com.freetirage.apitirage.repository.ListeRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListeServiceImpl implements ListeService{

    @Autowired
    ListeRepo listerepo;

    //creation de la liste
    @Override
    public Liste creer(Liste liste) {
        return listerepo.save(liste);
    }

    //recuperation de la liste par libelle
    @Override
    public Liste trouverListeParLibelle(String libele) {
        return listerepo.findByLibele(libele);
    }

//Afficher toute les listes
    @Override
    public List<Liste> afficher() {
        return listerepo.findAll();
    }

    @Override
    public Liste AfficherUNEListe(Long idliste) {
        return listerepo.findById(idliste).get();
    }


}
