package com.freetirage.apitirage.repository;

import com.freetirage.apitirage.model.Postulant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostulantRepo extends JpaRepository<Postulant, Long> {

    //selection des postulant sur la liste
    @Query(value = "select * from postulant where idlist_idliste = idlist_idliste", nativeQuery = true)
    public List<Postulant> FINDIDPOSTLIST( Long idliste);


}
