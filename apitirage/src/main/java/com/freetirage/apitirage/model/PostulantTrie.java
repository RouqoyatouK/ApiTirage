package com.freetirage.apitirage.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostulantTrie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idpostulant;
    private String nompostulant;
    private String prenompostulant;
    private String numeropostulant;
    private String email;

    //relation entre la table postulant trié et tirage
    @ManyToOne
    private Tirage idtirage;
}
