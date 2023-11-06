package tn.esprit.nejd_bedoui_project_4twin7.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.nejd_bedoui_project_4twin7.Models.*;

import java.util.List;

public interface IChambreRepository extends JpaRepository<Chambre,Long> {
    List<Chambre> findByTypeCAndBlocChambreAndReservations(TypeChambre type, Bloc bloc, Reservation reservation);

}
