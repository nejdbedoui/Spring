package tn.esprit.nejd_bedoui_project_4twin7.Services;

import tn.esprit.nejd_bedoui_project_4twin7.Models.Universite;

import java.util.List;

public interface IUniversiteService {
    Universite AjouterUniversite(Universite u);
    Universite UpdateUniversite(Universite u);
    void SupprimerUniversite(long idUniversite);
    Universite GetUniversite(long idUniversite);
    List<Universite> GetAllUuniversite();

    Universite findbyNomuniv(String nom);


    Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite);
    Universite desaffecterFoyerAUniversite (long idFoyer, long idUniversite) ;
}
