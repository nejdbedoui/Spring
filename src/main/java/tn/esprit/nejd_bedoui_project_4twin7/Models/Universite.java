package tn.esprit.nejd_bedoui_project_4twin7.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter

@Entity
public class Universite implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idUniversite;
    private String nomUniversite;
    private String adresse;

    @OneToOne
    private Foyer foyer;

}