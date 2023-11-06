package tn.esprit.nejd_bedoui_project_4twin7.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.nejd_bedoui_project_4twin7.Models.Foyer;

public interface IFoyerRepository extends JpaRepository<Foyer,Long> {
    Foyer findByNomFoyer(String nomFoyer);
}
