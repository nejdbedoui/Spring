package tn.esprit.nejd_bedoui_project_4twin7.Models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Getter
@Setter

@Entity
public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;
    private String numReservation;


    @Temporal(TemporalType.DATE)
    private LocalDate debuteAnneUniversite;

    @Temporal(TemporalType.DATE)
    private LocalDate finAnneUniversite;

    @Temporal(TemporalType.DATE)
    private Date anneeUniversitaire;
    private Boolean estValide;

    @ManyToOne
    private Chambre chamber;

    @ManyToMany
    private Set<Etudiant> etudiants;
}
