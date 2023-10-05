package tn.esprit.nejd_bedoui_project_4twin7.Models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Getter
@Setter

@Entity
public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;
    private Date anneeUniversitaire;
    private Boolean estValide;

    @ManyToOne
    private Chambre chamber;

    @ManyToMany
    private Set<Etudiant> etudiants;
}
