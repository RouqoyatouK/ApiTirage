package com.freetirage.apitirage.repository;


import com.freetirage.apitirage.model.Tirage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
@Repository
public interface TirageRepo extends JpaRepository<Tirage, Long> {

    Tirage findByLibelle(String libelle);

    //requete permettant d'inser un tirage avec son id
    @Modifying// permet de faire des insertion et des select car query ne fait que les insertion
    @Transactional
    @Query(value = "INSERT INTO Tirage(date, libelle, idliste_idliste) VALUES(NOW(),?,?)",nativeQuery = true)
    public int INSERERTIRAGE(String libelle, long idliste_idliste);
}
