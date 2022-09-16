package com.freetirage.apitirage.repository;


import com.freetirage.apitirage.model.Tirage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface TirageRepo extends JpaRepository<Tirage, Long> {

    Tirage findByLibelle(String libelle);


    //requete permettant d'inser un tirage avec son id
    @Modifying// permet de faire des insertion et des select car query ne fait que les insertion
    @Transactional
    @Query(value = "INSERT INTO Tirage(date, libelle, idliste_idliste) VALUES(NOW(),?,?)",nativeQuery = true)
    public int INSERERTIRAGE(String libelle, long idliste_idliste);


    //requête pour afficher tout les tirage d'une liste données
    @Query(value="select * from tirage where idliste_idliste = :idliste", nativeQuery = true)
    public List<Tirage> FindTirageByListId(@Param("idliste") long idliste);

    //le nombre de tirage sur une liste
    @Query(value = "select count(*) from tirage where idliste_idliste = :idliste", nativeQuery = true)
    public int LeNombreDeTirage(Long idliste);





}
