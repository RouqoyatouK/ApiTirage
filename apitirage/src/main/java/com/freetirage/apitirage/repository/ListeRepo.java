package com.freetirage.apitirage.repository;

import com.freetirage.apitirage.model.Liste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ListeRepo extends JpaRepository<Liste, Long> {

    Liste findByLibele(String libele);

    //List<Liste> findByIdliste(long idliste);

    @Modifying
    @Transactional
    @Query(value = "insert into postulant(idlist_idliste) values (?)", nativeQuery = true)
    public int INSERTIDLIST(Long idlist_id_liste);

    /*Afficher une liste par
    @Query(value = "select * from liste where idliste = :idliste", nativeQuery = true)
    public List<Liste> AfficherUneListe(Long idliste);*/



}
