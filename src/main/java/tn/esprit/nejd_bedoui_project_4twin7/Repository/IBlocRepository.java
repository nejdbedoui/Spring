package tn.esprit.nejd_bedoui_project_4twin7.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.nejd_bedoui_project_4twin7.Models.Bloc;
import tn.esprit.nejd_bedoui_project_4twin7.Models.Foyer;

import java.util.List;

public interface IBlocRepository extends JpaRepository<Bloc,Long> {
    Bloc findByNomBloc(String nombloc);
    List<Bloc> findByFoyer(Foyer foyer);
}
