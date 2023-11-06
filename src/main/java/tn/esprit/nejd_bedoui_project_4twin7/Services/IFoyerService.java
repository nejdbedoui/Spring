package tn.esprit.nejd_bedoui_project_4twin7.Services;

import tn.esprit.nejd_bedoui_project_4twin7.Models.Foyer;

import java.util.List;

public interface IFoyerService {
    Foyer Ajouterfoyer(Foyer f);
    Foyer Updatefoyer(Foyer f);
    void SupprimeFoyer(long idfoyer);
    Foyer Getfoyer(long idfoyer);

    List<Foyer> GetAllfoyer();
    Foyer ajouterFoyerEtAffecterAUniversite (Foyer foyer, long idUniversite) ;
}
