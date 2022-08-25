package com.freetirage.apitirage.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

//permet d'inclure les getter et setter et toString
@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Liste {
    //id de la liste
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idliste;

    private String libele;

    private Date date;
}
