package com.api.apitirage.Modele;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tirage {


    @Id
    @GeneratedValue
    private Long id;
    private Date date;
    private  String libelle;

    //relation entre la table tirage et la table liste
    @ManyToOne
    private Liste idliste;
}
