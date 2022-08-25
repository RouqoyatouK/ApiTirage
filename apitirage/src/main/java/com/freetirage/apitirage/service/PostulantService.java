package com.freetirage.apitirage.service;

import com.freetirage.apitirage.model.Postulant;

import java.util.List;
import com.freetirage.apitirage.model.Postulant;

import java.util.List;

public interface PostulantService {
    //methode permettant d'enregistrer un postulant
    List<Postulant> enregistrer(List<Postulant> listPost);

    //methode permettant de recuperer tous les postulant d'une liste donnée par l'id
    List<Postulant> TrouveridPostList(long idListe);
}
