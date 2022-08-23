package com.tirage.freetirage.repository;

import java.util.List;

import javax.transaction.Transactional;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import com.tirage.freetirage.Model.PostulantTrier;
import com.tirage.freetirage.Model.Tirage;

public interface PostulantTrieRepo extends JpaRepository<PostulantTrier, Long>{
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO postulant_trier(id_postulant,nom_Postulant,prenom_Postulant,numero_Postulant,email,tirage_idtirage) VALUE(?,?,?,?,?,?);", nativeQuery = true)
	public int INSERTPOSTTIRE(long idPostulant, String nomPostulant, String prenomPostulant, String numeroPostulant, String email, long tirage_idtirage);
	
	
	@Modifying
	@Transactional
	@Query(value = "SELECT * FROM postulant_trier where tirage_idtirage = :tirage_idtirage",nativeQuery = true)
	public List<PostulantTrier> FINDALLPOSTULANTTRIEPARID(@PathVariable int  tirage_idtirage);
	
	List<PostulantTrier> findByTirage(Tirage t);

}
