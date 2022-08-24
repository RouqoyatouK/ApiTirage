package com.api.apitirage.Modele;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class Postulant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPostulant;
    private String nom;
    private String prenom;
    private String numero;
    private String email;

    @ManyToOne
    private Liste liste;

    public Postulant(String nom, String prenom, String numero, String email) {
    }
}
