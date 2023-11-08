package tn.esprit.nejd_bedoui_project_4twin7.Services.Impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.nejd_bedoui_project_4twin7.Models.Chambre;
import tn.esprit.nejd_bedoui_project_4twin7.Models.Etudiant;
import tn.esprit.nejd_bedoui_project_4twin7.Models.Reservation;
import tn.esprit.nejd_bedoui_project_4twin7.Models.TypeChambre;
import tn.esprit.nejd_bedoui_project_4twin7.Repository.IBlocRepository;
import tn.esprit.nejd_bedoui_project_4twin7.Repository.IChambreRepository;
import tn.esprit.nejd_bedoui_project_4twin7.Repository.IEtudiantRepository;
import tn.esprit.nejd_bedoui_project_4twin7.Repository.IReservationRepository;
import tn.esprit.nejd_bedoui_project_4twin7.Services.IReservationService;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

@Service
@AllArgsConstructor
public class IReservationServiceImpl implements IReservationService {
    IReservationRepository resrvationRepository;
    IChambreRepository chambreRepository;
    IEtudiantRepository etudiantRepository;
    IBlocRepository iblocRepository;
    @Override
    public Reservation AjouterReservation(Reservation r) {
        return resrvationRepository.save(r);
    }

    @Override
    public Reservation UpdateReservation(Reservation r) {
        return resrvationRepository.save(r);
    }

    @Override
    public void SupprimerReservation(long idReservation) {
        resrvationRepository.deleteById( idReservation);
    }

    @Override
    public Reservation GetReservation(long idReservation) {
        return resrvationRepository.findById( idReservation).orElse(null);
    }

    @Override
    public List<Reservation> GetAllReservation() {
        return resrvationRepository.findAll();
    }

    @Override
    @Transactional
    public Reservation ajouterReservationEtAssignerAChambreEtAEtudiant(Reservation res, Long numChambre, Long cin) {
        Reservation resrvation = resrvationRepository.findById(res.getIdReservation()).orElse(null);
        Chambre ch=chambreRepository.findById(numChambre).orElse(null);
        if(ch.getReservations()==null){
            ch.setReservations(new HashSet<>());
        }
        ch.getReservations().add(resrvation);
        resrvation.getEtudiants().add(etudiantRepository.findEtudiantByCin(cin));
        return resrvation;
    }

    @Override
    public long getReservationParAnneeUniversitaire(Date debutAnnee, Date finAnnee) {
        List<Reservation> reservation =  resrvationRepository.findByAnneeUniversitaireBetween(debutAnnee, finAnnee);
        return reservation.size();
    }

    @Override
    public Reservation ajouterReservation(long idChambre, long cinEtudiant) {
        Chambre ch = chambreRepository.findById(idChambre).orElse(null);
        Etudiant et = etudiantRepository.findEtudiantByCin(cinEtudiant);
        Reservation r = new Reservation();
        r.setNumReservation(ch.getNumeroChambre()+"-"+ch.getBlocChambre().getNomBloc()+"-"+cinEtudiant);
        r.setDebuteAnneUniversite(LocalDate.parse(LocalDate.now().getYear() + "-09-01"));
        r.setFinAnneUniversite(LocalDate.parse((LocalDate.now().getYear() + 1) + "-06-01"));
        r.setEstValide(true);
        int c=ch.getReservations().size();
        if(r.getEtudiants()==null){
            r.setEtudiants(new HashSet<>());
        }
        if(ch.getReservations()==null){
            ch.setReservations(new HashSet<>());
        }
        if(ch.getTypeC()==TypeChambre.Simple && c<1 ){
            r=resrvationRepository.save(r);
            ch.getReservations().add(r);
            r.getEtudiants().add(et);
            chambreRepository.save(ch);
            return r;
        }

        if(ch.getTypeC()==TypeChambre.Double && c<2 ){
            r=resrvationRepository.save(r);
            ch.getReservations().add(r);
            r.getEtudiants().add(et);
            chambreRepository.save(ch);
            return r;
        }
        if(ch.getTypeC()==TypeChambre.Triple && c<3 ){
            r.getEtudiants().add(et);
            r=resrvationRepository.save(r);
            ch.getReservations().add(r);
            chambreRepository.save(ch);
            return r;
        }

        return null;
    }

    @Transactional
    @Override
    public Reservation annulerReservation(long cinEtudiant) {
        Etudiant e =etudiantRepository.findEtudiantByCin(cinEtudiant);
        List<Reservation> r = resrvationRepository.findByEtudiants(e);
        for(Reservation re:r) {
            Chambre ch = chambreRepository.findChambreByReservations(re);
            ch.getReservations().remove(re);
            re.getEtudiants().remove(e);
            re.setEstValide(false);
            resrvationRepository.save(re);
        }
        return null;
    }
}
