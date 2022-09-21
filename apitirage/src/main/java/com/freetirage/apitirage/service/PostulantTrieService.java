package com.freetirage.apitirage.service;



import com.freetirage.apitirage.model.PostulantTrie;

import java.util.List;

public interface PostulantTrieService {

    //methode permettant de créer les postulant trié
    int  creer(Long idpostulant, String nompostulant, String prenompostulant, String numeropostulant, String email, Long idtirage_id);

    //methode permettant de retourner les postulant d'untirage donnée
    List<PostulantTrie> trouverPostulantTrieParIdtirage(Long idtirage_id);

    List<Object[]> listepostulant();
}
