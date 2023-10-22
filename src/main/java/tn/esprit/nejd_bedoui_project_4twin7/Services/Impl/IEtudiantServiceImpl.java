package tn.esprit.nejd_bedoui_project_4twin7.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.nejd_bedoui_project_4twin7.Models.Etudiant;
import tn.esprit.nejd_bedoui_project_4twin7.Repository.IEtudiantRepository;
import tn.esprit.nejd_bedoui_project_4twin7.Services.IEtudiantService;

import java.util.List;

@Service
public class IEtudiantServiceImpl implements IEtudiantService {
    @Autowired
    IEtudiantRepository iEtudiantRepository;
    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return iEtudiantRepository.findAll();
    }

    @Override
    public List<Etudiant> addEtudiants(List<Etudiant> etudiants) {
        return iEtudiantRepository.saveAll(etudiants);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        Etudiant etudiant=iEtudiantRepository.findById(e.getIdEtudiant()).orElse(null);
        if(etudiant!=null){
            etudiant.setCin(e.getCin() == null ? etudiant.getCin() : e.getCin());
            etudiant.setReservations(e.getReservations() ==null ? etudiant.getReservations() : e.getReservations());
            etudiant.setEcole(e.getEcole() == null ? etudiant.getEcole() : e.getEcole());
            etudiant.setNomEt(e.getNomEt() == null ? etudiant.getNomEt() : e.getNomEt());
            etudiant.setPrenomEt(e.getPrenomEt() == null ? etudiant.getPrenomEt() : e.getPrenomEt());
            etudiant.setDateNaissance(e.getDateNaissance() == null ? etudiant.getDateNaissance() : e.getDateNaissance());
            return iEtudiantRepository.save(etudiant);
        }
        return null;
    }

    @Override
    public Etudiant retrieveEtudiant(long idEtudiant) {
        return iEtudiantRepository.findById(idEtudiant).orElse(null);
    }

    @Override
    public void removeEtudiant(long idEtudiant) {
        Etudiant etudiant= iEtudiantRepository.findById(idEtudiant).orElse(null);
        if(etudiant!=null)
            iEtudiantRepository.delete(etudiant);
    }
}
