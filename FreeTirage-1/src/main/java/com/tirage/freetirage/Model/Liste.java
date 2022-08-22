package com.tirage.freetirage.Model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;





@Entity
public class Liste {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idListe;
	
	private String libelle;
    private  Date date ;

    
	public Liste(int idListe, String libelle, Date date, List<Liste> liste) {
		super();
		this.idListe = idListe;
		this.libelle = libelle;
		this.date = date;
		
	}
	
	public Liste() {
	}

	public int getIdListe() {
		return idListe;
	}

	public void setIdListe(int idListe) {
		this.idListe = idListe;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
    
    
    
    
}
