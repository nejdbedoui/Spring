package tn.esprit.nejd_bedoui_project_4twin7.Services;

import tn.esprit.nejd_bedoui_project_4twin7.Models.Chambre;

import java.util.List;

public interface IChambreService {
    List<Chambre> retrieveAllChambres();
    Chambre addChambre(Chambre c); // ajouter l’équipe avec son détail
    Chambre updateChambre (Chambre c);
    Chambre retrieveChambre (long idChambre);
}
