package com.tirage.freetirage.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tirage.freetirage.Model.Liste;
import com.tirage.freetirage.Model.Postulant;
import com.tirage.freetirage.service.ListeService;
import com.tirage.freetirage.service.PostulantService;
import com.tirage.freetirage.service.PostulantServiceImpl;


@RestController
@RequestMapping("/postulant")
public class PostulantController {
	@Autowired
	PostulantService postulantservive;
	
	@Autowired
	ListeService listeservice;

    @PostMapping("/importe/{libelle}")
    public String importerFichier(@Param("file") MultipartFile file,@PathVariable("libelle") String libelle){
    	
    	Liste liste=new Liste();
    	liste.setLibelle(libelle);
    	liste.setDate(new Date());
        Liste l = listeservice.creer(liste);
    	
    	//PostulantServiceImpl excelImport = new PostulantServiceImpl();
    	//List<Postulant> listpostulant = excelImport.InsertPostulant();
    	List<Postulant> listpostulant = postulantservive.importerFichier(file);

    	
    	if(listpostulant.size()==0){
            return "Fichier vide";
        }
    	
    	else{
        
	        for (Postulant p:listpostulant){
	           p.setListe(l);
	           postulantservive.Ajouter(p);
	        }
	        
	    	//postulantservive.importerFichier(file);
	        
     }
    	return "Fichier importé";
    }
}
