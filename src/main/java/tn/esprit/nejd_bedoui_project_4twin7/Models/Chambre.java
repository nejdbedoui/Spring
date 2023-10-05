package tn.esprit.nejd_bedoui_project_4twin7.Models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter

@Entity
public class Chambre implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idChambre;
    private Long numeroChambre;
    private TypeChambre typeC;

    @ManyToOne
    private Bloc bloc_chambre;

    @OneToMany(mappedBy = "chamber")
    private Set<Reservation> reservations;
}