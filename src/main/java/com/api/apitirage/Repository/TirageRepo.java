package com.api.apitirage.Repository;

import com.api.apitirage.Modele.Tirage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface TirageRepo extends JpaRepository<Tirage, Long> {

    Tirage findByLibellet(String libelle);

    //requete permettant d'inser un tirage avec son id
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO tirage(date, libelle, idliste_id_liste) VALUES(NOW(),?,?);",nativeQuery = true)
    public int INSERERTIRAGE(String libelle, long idliste_id_liste);
}
