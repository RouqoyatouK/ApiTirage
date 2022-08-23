package com.tirage.freetirage.service;

import java.util.List;

import com.tirage.freetirage.Model.Postulant;
import com.tirage.freetirage.Model.Tirage;

public interface TirageService {
	//le premier List<Postulant>  represente la liste qui sera retourner apres tri il prends en pâramètre nbr le nbre de tri, le json tirage et la liste a trier
	List<Postulant> creer(Tirage tirage, int nbr, List<Postulant> listAtrier);
	
	//la methode qui fait en sorte de ne pas avoir plusieur tri sur la même liste avec le même libellé et nbr
//	Tirage trouverTirageParLibelle(String libelle);
//
//	List<Postulant> trie(List<Postulant> postuL, int nbr);
	

	Tirage save(Tirage tirage);
}
