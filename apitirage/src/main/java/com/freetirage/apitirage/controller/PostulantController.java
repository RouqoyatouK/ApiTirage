package com.freetirage.apitirage.controller;

import com.freetirage.apitirage.model.Liste;
import com.freetirage.apitirage.model.Postulant;
import com.freetirage.apitirage.model.PostulantExcelimport;
import com.freetirage.apitirage.service.ListeService;
import com.freetirage.apitirage.service.PostulantService;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/postulant")
@AllArgsConstructor
public class PostulantController {

    PostulantService postulantservice;
    ListeService listeservice;


    @PostMapping("/importe/{libelle}")

    public String importFormExcel(@Param("file") MultipartFile file, Liste liste, String libelle) {

        //instance de la classe qui permet l'import la lecture du fichier afin de la mettre dans la table postulant
        PostulantExcelimport excelImporter = new PostulantExcelimport();

        //stockage de la liste des postulants retournée par la classe "PostulantExcelimport"  dans postulantList
        List<Postulant> postulantList = excelImporter.excelImport(file);
        liste.setDate(new Date());//la liste prendra automatiqquement la date du système

        if(listeservice.trouverListeParLibelle(liste.getLibelle()) == null){//si la liste n'existepas

            Liste l= listeservice.creer(liste);//on crée la liste et garder cette liste dans l

            for (Postulant p:postulantList) {
                p.setIdlist(l);//ajout de l'id de la liste à tous les  postulants(secondary key)
            }

            postulantservice.enregistrer(postulantList);//enregistrement de la liste des postulants importés dans la base
            return "importé avec succes";
        } else {
            return "Cette liste existe déjà";
        }

    }




}
