package com.freetirage.apitirage.controller;

import com.freetirage.apitirage.model.Liste;
import com.freetirage.apitirage.model.Postulant;
import com.freetirage.apitirage.model.PostulantExcelimport;
import com.freetirage.apitirage.repository.PostulantRepo;
import com.freetirage.apitirage.service.ListeService;
import com.freetirage.apitirage.service.PostulantService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/postulant")
@AllArgsConstructor
public class PostulantController {
@Autowired
    PostulantService postulantservice;
@Autowired
    ListeService listeservice;
@Autowired
    PostulantRepo postulantrepo;


@GetMapping("/{idliste}")
public int AfficherNombre(@PathVariable Long idliste){
    return postulantrepo.LeNombreDePOstulant(idliste);
}

    @PostMapping("/importe/{libele}")
    public String importFormExcel(@Param("file") MultipartFile file, Liste liste) {

        //instance de la classe qui permet l'import la lecture du fichier afin de la mettre dans la table postulant
        PostulantExcelimport excelImporter = new PostulantExcelimport();

        //stockage de la liste des postulants retournée par la classe "PostulantExcelimport"  dans postulantList
        List<Postulant> postulantList = excelImporter.excelImport(file);
        liste.setDate(new Date());//la liste prendra automatiqquement la date du système

        if(listeservice.trouverListeParLibelle(liste.getLibele()) == null){ //si la liste n'existepas

            Liste l= listeservice.creer(liste);//on crée la liste et garder cette liste dans l

            for (Postulant p:postulantList) {
                // on parcours la liste tout en ajoutant l'id "Postulant p:postulantList"
                p.setIdlist(l);//ajout de l'id de la liste à tous les  postulants(secondary key)
            }

            postulantservice.enregistrer(postulantList);//enregistrement de la liste des postulants importés dans la base
            return "importé avec succes";
        } else {
            return "Cette liste existe déjà";
        }

    }




}
