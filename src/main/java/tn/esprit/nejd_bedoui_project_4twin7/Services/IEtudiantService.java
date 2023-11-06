package tn.esprit.nejd_bedoui_project_4twin7.Services;

import tn.esprit.nejd_bedoui_project_4twin7.Models.Etudiant;

import java.util.List;

public interface IEtudiantService {
    Etudiant AjouterEtudiant(Etudiant e);
    Etudiant UpdateEtudiant (Etudiant e);
    void SupprimerEtdiant (long idEtudiant);
    Etudiant GetEtudiant(long idEtudiant);
    List<Etudiant> GetAllEtudiant();
}
