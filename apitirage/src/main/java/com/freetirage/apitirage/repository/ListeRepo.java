package com.freetirage.apitirage.repository;

import com.freetirage.apitirage.model.Liste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface ListeRepo extends JpaRepository<Liste, Long> {

    Liste findByLibelle(String libelle);

    @Modifying
    @Transactional
    @Query(value = "insert into postulant(idlist_idliste) values (?)", nativeQuery = true)
    public int INSERTIDLIST(Long idlist_id_liste);
}
