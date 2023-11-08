package tn.esprit.nejd_bedoui_project_4twin7.Services;

import org.springframework.transaction.annotation.Transactional;
import tn.esprit.nejd_bedoui_project_4twin7.Models.Reservation;

import java.util.Date;
import java.util.List;

public interface IReservationService {
    Reservation AjouterReservation(Reservation r);
    Reservation UpdateReservation(Reservation r);
    void SupprimerReservation(long idReservation);
    Reservation GetReservation(long idReservation);
    List<Reservation> GetAllReservation();
    Reservation ajouterReservationEtAssignerAChambreEtAEtudiant (Reservation res, Long
            numChambre, Long cin) ;
    long getReservationParAnneeUniversitaire(Date debutAnnee, Date finAnnee ) ;
    public Reservation ajouterReservation (long idChambre, long cinEtudiant) ;

    @Transactional
    Reservation annulerReservation(long cinEtudiant);
}
