package tn.esprit.nejd_bedoui_project_4twin7.Services;

import tn.esprit.nejd_bedoui_project_4twin7.Models.Foyer;

import java.util.List;

public interface IFoyerService {
    List<Foyer> retrieveAllFoyers();
    Foyer addFoyer (Foyer f);
    Foyer updateFoyer (Foyer f);
    Foyer retrieveFoyer (long idFoyer);
    void removeFoyer (long idFoyer);
}
