package tn.esprit.nejd_bedoui_project_4twin7.Models;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter

@Entity
public class Chambre implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idChambre;
    private Long numeroChambre;
    private TypeChambre typeC;
}