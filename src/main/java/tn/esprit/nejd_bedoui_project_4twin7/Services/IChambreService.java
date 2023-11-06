package tn.esprit.nejd_bedoui_project_4twin7.Services;

import tn.esprit.nejd_bedoui_project_4twin7.Models.Chambre;
import tn.esprit.nejd_bedoui_project_4twin7.Models.TypeChambre;

import java.util.List;

public interface IChambreService {
    Chambre AjoutChambre(Chambre c);
    Chambre UpdateChambre(Chambre c);
    void SupprimerChambre(long idChambre);
    Chambre GetChambre(long idChambre);
    List<Chambre> GetAllChambres();
    List<Chambre> getChambresParNomBloc( String nomBloc) ;
    long nbChambreParTypeEtBloc(TypeChambre type, long idBloc) ;
    List<Chambre> getChambresNonReserveParNomFoyerEtTypeChambre( String nomFoyer,TypeChambre type) ;

}
