package com.freetirage.apitirage.service;

import com.freetirage.apitirage.model.Liste;

public interface ListeService {
    //methode permettant de creer  une liste
    Liste creer(Liste liste);

    //methode(trouverListeParLibelle) permettant de recuperer une liste par son libelle
    Liste trouverListeParLibelle(String libele);


}
