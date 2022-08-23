package com.tirage.freetirage.repository;

import java.util.List;

import javax.transaction.Transactional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tirage.freetirage.Model.Liste;
import com.tirage.freetirage.Model.Postulant;

public interface PostulantRepo extends JpaRepository<Postulant, Long> {
	@Modifying
    @Transactional
    @Query(value = "INSERT INTO postulant(nom, prenom, numero, email) values(?,?,?,?)", nativeQuery = true)
	public int InsertPostulant(String nom, String prenom, String numero, String email);
	
	
	@Query(value="SELECT * FROM Postulant Where liste_id_liste= :liste_id_liste ", nativeQuery = true)
	public List<Postulant> trouveridPostList(@Param("liste_id_liste") long liste_id_liste);

	List<Postulant> findByListe(Liste liste);
	
	//importerFichierExcel recupperer le postulanyt par la liste
	
	List<Postulant> findByListImport(Liste listeImport);
}
