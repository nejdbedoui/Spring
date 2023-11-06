package tn.esprit.nejd_bedoui_project_4twin7.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.nejd_bedoui_project_4twin7.Models.Chambre;
import tn.esprit.nejd_bedoui_project_4twin7.Models.Reservation;

import java.util.Date;
import java.util.List;

public interface IReservationRepository extends JpaRepository<Reservation,Long> {
    List<Reservation> findByAnneeUniversitaireBetween(Date debutAnnee, Date finAnnee);
    List<Reservation> findByChamber(Chambre chambre);
}
