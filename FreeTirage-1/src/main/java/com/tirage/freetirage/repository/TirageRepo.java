package com.tirage.freetirage.repository;



import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tirage.freetirage.Model.Tirage;

public interface TirageRepo extends JpaRepository<Tirage, Long> {
	
	//Tirage findByLibelle(String libellet);
	
	    //@Modifying
	    //@Transactional
	    //@Query(value = "INSERT INTO tirage(date, libellet, idliste_id_liste) VALUES(NOW(),?,?);",nativeQuery = true)
	    //public int INSERERTIRAGE(String libelle, int liste_id_liste);


}
