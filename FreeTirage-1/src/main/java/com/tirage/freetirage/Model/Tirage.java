package com.tirage.freetirage.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class Tirage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idtirage;
    private String libelle;
    private Date date;
    
    
    @ManyToOne
   private Liste liste;


	public Tirage(Long idtirage, String libelle, Date date, Liste liste) {
		super();
		this.idtirage = idtirage;
		this.libelle = libelle;
		this.date = date;
		this.liste = liste;
	}


	public Tirage() {
		super();
	}


	public Long getIdtirage() {
		return idtirage;
	}


	public void setIdtirage(Long idtirage) {
		this.idtirage = idtirage;
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


	public Liste getListe() {
		return liste;
	}


	public void setListe(Liste liste) {
		this.liste = liste;
	}


	
    
   
}
