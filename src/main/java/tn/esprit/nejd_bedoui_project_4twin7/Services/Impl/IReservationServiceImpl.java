package tn.esprit.nejd_bedoui_project_4twin7.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.nejd_bedoui_project_4twin7.Models.Reservation;
import tn.esprit.nejd_bedoui_project_4twin7.Repository.IReservationRepository;
import tn.esprit.nejd_bedoui_project_4twin7.Services.IReservationService;

import java.util.List;

@Service
public class IReservationServiceImpl implements IReservationService {
    @Autowired
    IReservationRepository iReservationRepository;
    @Override
    public List<Reservation> retrieveAllReservation() {
        return iReservationRepository.findAll();
    }

    @Override
    public Reservation addReservation(Reservation r) {
        return iReservationRepository.save(r);
    }

    @Override
    public Reservation updateReservation(Reservation res) {
        Reservation reservation=iReservationRepository.findById(res.getIdReservation()).orElse(null);
        if(reservation!=null){
            reservation.setChamber(res.getChamber() == null ? reservation.getChamber() : res.getChamber());
            reservation.setEtudiants(res.getEtudiants() ==null ? reservation.getEtudiants() : res.getEtudiants());
            reservation.setEstValide(res.getEstValide() == null ? reservation.getEstValide() : res.getEstValide());
            reservation.setAnneeUniversitaire(res.getAnneeUniversitaire() == null ? reservation.getAnneeUniversitaire() : res.getAnneeUniversitaire());
            return iReservationRepository.save(reservation);
        }
        return null;
    }

    @Override
    public Reservation retrieveReservation(long idReservation) {
        return iReservationRepository.findById(idReservation).orElse(null);
    }
}
