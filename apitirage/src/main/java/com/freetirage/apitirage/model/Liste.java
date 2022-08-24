package com.freetirage.apitirage.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

//permet d'inclure les getter et setter et toString
@Data
//constrcteur sans paramêtre
@NoArgsConstructor

@Entity
public class Liste {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //id de la liste
    private long idliste;

    private String libelle;

    private Date date;
}
