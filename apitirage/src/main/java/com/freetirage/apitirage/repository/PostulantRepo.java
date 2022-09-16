package com.freetirage.apitirage.repository;

import com.freetirage.apitirage.model.Postulant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PostulantRepo extends JpaRepository<Postulant, Long> {

    //selection des postulant sur la liste
    @Query(value = "select * from postulant where idlist_idliste = idlist_idliste", nativeQuery = true)
    public List<Postulant> FINDIDPOSTLIST( Long idliste);

    //retourne le nombre de postulant sur une liste
    @Query(value = "select count(*) from postulant where idlist_idliste = :idliste", nativeQuery = true)
    public int LeNombreDePOstulant(Long idliste);


}
