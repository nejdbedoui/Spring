package tn.esprit.nejd_bedoui_project_4twin7.Services.Impl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.nejd_bedoui_project_4twin7.Models.Etudiant;
import tn.esprit.nejd_bedoui_project_4twin7.Repository.IEtudiantRepository;
import tn.esprit.nejd_bedoui_project_4twin7.Services.IEtudiantService;

import java.util.List;

@Service
@AllArgsConstructor
public class IEtudiantServiceImpl implements IEtudiantService {
    IEtudiantRepository etudiantRepository;
    @Override
    public Etudiant AjouterEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant UpdateEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public void SupprimerEtdiant(long idEtudiant) {
        etudiantRepository.deleteById( idEtudiant);

    }

    @Override
    public Etudiant GetEtudiant(long idEtudiant) {
        return etudiantRepository.findById(idEtudiant).orElse(null);
    }

    @Override
    public List<Etudiant> GetAllEtudiant() {
        return etudiantRepository.findAll();
    }
}
