package tn.esprit.nejd_bedoui_project_4twin7.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.nejd_bedoui_project_4twin7.Models.Universite;

public interface IUniversiteRepository extends JpaRepository<Universite,Long> {
    Universite findByNomUniversite(String nom);
}
