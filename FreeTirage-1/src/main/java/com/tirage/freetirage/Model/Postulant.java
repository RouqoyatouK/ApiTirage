package com.tirage.freetirage.Model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;





@Entity
public class Postulant {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long idPostulant;
	    private String nom;
	    private String prenom;
	    private String numero;
	    private String email;
	    
	    @ManyToOne
		private Liste liste;

		public Postulant(Long idPostulant, String nom, String prenom, String numero, String email, Liste liste) {
			super();
			this.idPostulant = idPostulant;
			this.nom = nom;
			this.prenom = prenom;
			this.numero = numero;
			this.email = email;
			this.liste = liste;
		}
		
		public Postulant() {}

		public Long getIdPostulant() {
			return idPostulant;
		}

		public void setIdPostulant(Long idPostulant) {
			this.idPostulant = idPostulant;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public String getPrenom() {
			return prenom;
		}

		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}

		public String getNumero() {
			return numero;
		}

		public void setNumero(String numero) {
			this.numero = numero;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public Liste getListe() {
			return liste;
		}

		public void setListe(Liste liste) {
			this.liste = liste;
		}
	    
	    
	    

}
