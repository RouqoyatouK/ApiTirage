package com.api.apitirage.Service;

import com.api.apitirage.Modele.PostulantTrie;
import com.api.apitirage.Repository.PostulantTrieRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PostulantTrieServiceImpl implements PostulantTrieService{


    @Autowired
    private  final PostulantTrieRepo postulantTrieRepo;

    //redefinition de la methode permettant de creer les postulant trié
    @Override
    public int creer(Long idpostulant, String nompostulant, String prenompostulant, String numeropostulant, String email, Long idtirage_id) {

        //creation des postulant trié
        return postulantTrieRepo.INSERTPOSTTIRE(idpostulant, nompostulant, prenompostulant, numeropostulant, email, idtirage_id);
    }

    //redefinition de la methode qui retourne les postulant trié d'un tirage
    @Override
    public List<PostulantTrie> trouverPostulantTrieParIdtirage(Long idtirageid) {
        //retour des postulant trié
        return postulantTrieRepo.FINDALLPOSTULANTTRIEPARID(idtirageid);
    }
}
