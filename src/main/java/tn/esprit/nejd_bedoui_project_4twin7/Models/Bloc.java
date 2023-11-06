package tn.esprit.nejd_bedoui_project_4twin7.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter

@Entity
public class Bloc  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBloc;
    private String nomBloc;
    private Long capaciteBloc;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Foyer foyer;

    @OneToMany(mappedBy = "blocChambre")
    private Set<Chambre> chambres;
}
