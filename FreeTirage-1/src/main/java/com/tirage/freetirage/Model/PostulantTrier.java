package com.tirage.freetirage.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PostulantTrier {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPostulant;
	private String nom_Postulant;
	private String prenom_Postulant;
	private String numero_Postulant;
	private String email;
	
	@ManyToOne
	private Tirage tirage;
	
	
	public PostulantTrier(int idPostulant, String nom_Postulant, String prenom_Postulant, String numero_Postulant,
			String email, Tirage tirage) {
		super();
		this.idPostulant = idPostulant;
		this.nom_Postulant = nom_Postulant;
		this.prenom_Postulant = prenom_Postulant;
		this.numero_Postulant = numero_Postulant;
		this.email = email;
		this.tirage = tirage;
		
	}

	public PostulantTrier() {
		super();
	}

	public long getIdPostulant() {
		return idPostulant;
	}

	public void setIdPostulant(int idPostulant) {
		this.idPostulant = idPostulant;
	}

	public String getNom_Postulant() {
		return nom_Postulant;
	}

	public void setNom_Postulant(String nom_Postulant) {
		this.nom_Postulant = nom_Postulant;
	}

	public String getPrenom_Postulant() {
		return prenom_Postulant;
	}

	public void setPrenom_Postulant(String prenom_Postulant) {
		this.prenom_Postulant = prenom_Postulant;
	}

	public String getNumero_Postulant() {
		return numero_Postulant;
	}

	public void setNumero_Postulant(String numero_Postulant) {
		this.numero_Postulant = numero_Postulant;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Tirage getTirage() {
		return tirage;
	}

	public void setTirage(Tirage tirage) {
		this.tirage = tirage;
	}

		

}
