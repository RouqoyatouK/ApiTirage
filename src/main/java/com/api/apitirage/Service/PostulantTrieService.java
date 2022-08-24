package com.api.apitirage.Service;

import com.api.apitirage.Modele.PostulantTrie;

import java.util.List;

public interface PostulantTrieService {

    //methode permettant de créer les postulant trié
    int  creer(Long idpostulant, String nompostulant, String prenompostulant, String numeropostulant, String email, Long idtirage_id);

    //methode permettant de retourner les postulant d'untirage donnée
    List<PostulantTrie> trouverPostulantTrieParIdtirage(Long idtirageid);
}
