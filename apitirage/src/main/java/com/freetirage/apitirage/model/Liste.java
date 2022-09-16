package com.freetirage.apitirage.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    //Aide a recuperer l'ensemble des tirage sur une liste donner
    @JsonIgnore
    @OneToMany(mappedBy = "idliste")
    List<Tirage> tirageList=new ArrayList<>();
}
