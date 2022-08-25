package com.freetirage.apitirage.model;


import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Postulant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idpostulant;

    private String nom;

    private String prenom;

    private String numero;
    private String email;

    //relation de la table postulant et la table liste(les trois ligne ci-dessous
    @ManyToOne
    private Liste idlist;

    public Postulant(String nom, String prenom, String numero, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.numero = numero;
        this.email = email;
    }

    //constructeur avec argument

}
