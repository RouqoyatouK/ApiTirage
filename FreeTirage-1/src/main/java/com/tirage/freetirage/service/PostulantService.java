package com.tirage.freetirage.service;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.web.multipart.MultipartFile;

import com.tirage.freetirage.Model.Liste;
import com.tirage.freetirage.Model.Postulant;

public interface PostulantService {
	
	 List<Postulant> importerFichier(MultipartFile file);

	 List<Postulant> Lire();
	 
	 Postulant Ajouter(Postulant p);
	 
	 //List<Postulant> trouveridPostList(long liste_id_liste);
	 
	 List<Postulant> TrouverParListe(Liste liste);
	 
	 
}
