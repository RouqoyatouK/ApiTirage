package com.api.apitirage.Modele;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Liste {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idliste;
    private String libelle;
    private Date date;


}
