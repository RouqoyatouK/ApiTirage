package com.tirage.freetirage.repository;

import javax.transaction.Transactional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.tirage.freetirage.Model.Postulant;

public interface PostulantRepo extends JpaRepository<Postulant, Long> {
	@Modifying
    @Transactional
    @Query(value = "INSERT INTO postulant(nom, prenom, numero, email) values(?,?,?,?)", nativeQuery = true)
	 int InsertPostulant(String nom, String prenom, String numero, String email);

}
