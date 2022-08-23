package com.tirage.freetirage.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tirage.freetirage.Model.Postulant;
import com.tirage.freetirage.Model.Tirage;
import com.tirage.freetirage.repository.TirageRepo;

@Service
public class TirageServiceImpl implements TirageService{
	
	@Autowired
	TirageRepo tiragerepo;

	@Override
	public List<Postulant> creer(Tirage tirage, int nbr, List<Postulant> listAtrier) {
		// TODO Auto-generated method stub
		
		//c'est une classe qui permet de faire le tri aleatoirement
		Random rdm = new Random();
		
		//liste contiendra la liste apres tri
		 List<Postulant> liste = new ArrayList<>();
		 for (int i = 0; i < nbr; i++) {
			 
			 //declaration de index qui va parcourrir la taille de la liste a trier de façon aleatoire  tout en retournant des int
			 Integer index = rdm.nextInt(listAtrier.size());
			 
			 //Ajoute les index a notre nouvelle list "liste"
			 liste.add(listAtrier.get(index));
			 
			 //lorsqu'il parcours la liste les index dejà pris seront deleter pour eviter de les reprendre
			 
			 listAtrier.remove(listAtrier.get(index));
			 }
		
		 //tiragerepo.save(tirage);
		 return liste;
	}

	@Override
	public Tirage save(Tirage tirage) {
		// TODO Auto-generated method stub
		return tiragerepo.save(tirage);
	}

//	@Override
//	public Tirage trouverTirageParLibelle(String libelle) {
//		// TODO Auto-generated method stub
//		return null; //tiragerepo.findByLibelle(String libelle);
//	}
//
//	@Override
//	public List<Postulant> trie(List<Postulant> postuL, int nbr) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
