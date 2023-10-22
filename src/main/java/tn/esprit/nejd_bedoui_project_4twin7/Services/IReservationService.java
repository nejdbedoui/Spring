package tn.esprit.nejd_bedoui_project_4twin7.Services;

import tn.esprit.nejd_bedoui_project_4twin7.Models.Reservation;

import java.util.List;

public interface IReservationService {
    List<Reservation> retrieveAllReservation();
    Reservation addReservation(Reservation r);
    Reservation updateReservation (Reservation res);
    Reservation retrieveReservation (long idReservation);
}
