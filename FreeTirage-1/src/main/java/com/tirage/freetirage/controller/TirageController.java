package com.tirage.freetirage.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tirage.freetirage.Model.Liste;
import com.tirage.freetirage.Model.Postulant;
import com.tirage.freetirage.Model.PostulantTrier;
import com.tirage.freetirage.Model.Tirage;
import com.tirage.freetirage.service.ListeService;
import com.tirage.freetirage.service.PostulantService;
import com.tirage.freetirage.service.PostulantTriService;
import com.tirage.freetirage.service.PostulantTrierServiceImpl;
import com.tirage.freetirage.service.TirageService;

@RestController
@RequestMapping("/tirage")
public class TirageController {

	@Autowired
	TirageService tirageservice;
	@Autowired
	ListeService listeservice;
	@Autowired
	PostulantService postulantservice;
	@Autowired
	PostulantTriService postulantTrierService;
	PostulantTrierServiceImpl postulantservicetrieimpl;
	
	@PostMapping("/createTirage/{libelle}/{nbr}")

	 public List<PostulantTrier> create( @PathVariable("libelle") String libelle, @PathVariable("nbr") int nbr){
		Tirage tirage=new Tirage();
		//if(tirageservice.trouverTirageParLibelle(tirage.getLibelle()) == null) {//verifie si le tirage existe déjà
			 
			 
			 Liste liste = listeservice.trouverListeParLibelle(libelle);
			 long idliste = liste.getIdListe();//identifiant de la liste entrée par l'user
			 
			 tirage.setListe(liste);
			 tirage.setDate(new Date());
			 
			 Tirage t=tirageservice.save(tirage);
			//retourne tous les postulants d'une liste donnée
			 List<Postulant> postuL = postulantservice.TrouverParListe(liste);
			 
			 List<Postulant>  tt = tirageservice.creer(tirage, nbr,postuL);
	         //List<Postulant> lp = tirageservice.trie(postuL, nbr);//recuperation des postulant trié
		
	         //long idTirage = tt.getIdtirage();
	            for (Postulant p : tt){
	            	PostulantTrier posTri=new PostulantTrier();
	            	posTri.setTirage(t);
	            	posTri.setEmail(p.getEmail());
	            	posTri.setNom_Postulant(p.getNom());
	            	posTri.setNumero_Postulant(p.getNumero());
	            	posTri.setPrenom_Postulant(p.getPrenom());
	            	postulantservice.Ajouter(p);
	            	//postulantservicetrieimpl.creer(p.getIdPostulant(), p.getNom(), p.getPrenom(), p.getNumero(), p.getEmail(), idTirage);
		
	            }
		
		return postulantTrierService.findByTirage(t);
//		}
//		 else {
//			 return null;
//		 }
	}
}
