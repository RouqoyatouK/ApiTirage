package com.freetirage.apitirage.model;

import com.freetirage.apitirage.model.Liste;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@Getter
@Setter
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
