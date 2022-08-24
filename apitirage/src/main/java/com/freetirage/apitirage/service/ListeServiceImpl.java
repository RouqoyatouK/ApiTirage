package com.freetirage.apitirage.service;

import com.freetirage.apitirage.model.Liste;
import com.freetirage.apitirage.repository.ListeRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ListeServiceImpl implements ListeService{

    ListeRepo listerepo;

    //creation de la liste
    @Override
    public Liste creer(Liste liste) {
        return listerepo.save(liste);
    }

    //recuperation de la liste par libelle
    @Override
    public Liste trouverListeParLibelle(String libelle) {
        return listerepo.findByLibelle(libelle);
    }
}
