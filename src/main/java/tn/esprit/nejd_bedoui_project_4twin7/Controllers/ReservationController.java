package tn.esprit.nejd_bedoui_project_4twin7.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.nejd_bedoui_project_4twin7.Models.Reservation;
import tn.esprit.nejd_bedoui_project_4twin7.Services.IReservationService;
import tn.esprit.nejd_bedoui_project_4twin7.Services.Impl.IReservationServiceImpl;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/reservation")
@RequiredArgsConstructor
public class ReservationController {
    final public IReservationService reservationService;
    @GetMapping("ALLReservation")
    public List<Reservation> getAllReservation(){return reservationService.GetAllReservation();}
    @PostMapping("addReservation")
    public Reservation Addbloc(@RequestBody Reservation r){return reservationService.AjouterReservation(r);}
    @DeleteMapping("deleteReservation/{id}")
    public void Deletefoyer(@PathVariable long id){

        reservationService.SupprimerReservation(id);}

    @PutMapping("UpdateReservation")
    public Reservation MOdifierBlocs(@RequestBody Reservation r)
    {
        return reservationService.UpdateReservation(r);
    }
    @PutMapping("ajouterReservationEtAssignerAChambreEtAEtudiant/{numChambre}/{id_etudiant}")
    public Reservation ajouterReservationEtAssignerAChambreEtAEtudiant( @RequestBody Reservation r, @PathVariable long numChambre, @PathVariable long id_etudiant)
    {
        return reservationService.ajouterReservationEtAssignerAChambreEtAEtudiant(r,numChambre,id_etudiant);
    }
    @GetMapping("getReservationParAnneeUniversitaire/{debutAnnee}/{finAnnee}")
    public long getReservationParAnneeUniversitaire(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date debutAnnee,
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date finAnnee){
        return reservationService.getReservationParAnneeUniversitaire(debutAnnee, finAnnee);
    }
@PostMapping("affecterChambre/{id}/{cin}")
    public Reservation affecter(@PathVariable Long id,@PathVariable Long cin){
        return reservationService.ajouterReservation(id,cin);
}

}
