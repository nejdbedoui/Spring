package tn.esprit.nejd_bedoui_project_4twin7.Models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter

@Entity
public class Foyer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFoyer;
    private String nomFoyer;
    private Long capaciteFoyer;

    @OneToOne(mappedBy = "foyer")
    private Universite universite;
}