package com.tirage.freetirage.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;


import com.tirage.freetirage.Model.Postulant;

public interface PostulantService {
	
	 List<Postulant> importerFichier(MultipartFile file);

	 List<Postulant> Lire();
	 
	 Postulant Ajouter(Postulant p);
	 
	 
	 
	 
}
