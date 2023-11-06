package tn.esprit.nejd_bedoui_project_4twin7.Services;

import tn.esprit.nejd_bedoui_project_4twin7.Models.Bloc;

import java.util.List;

public interface IBlocService {
    Bloc AjouterBloc(Bloc b);
    Bloc UpdateBloc(Bloc b);
    void SupprimerBloc(long idBloc );
    Bloc GetBloc(long idBloc);
    List<Bloc> GetAllBlocs();
    public Bloc affecterChambresABloc(List<Long> numChambre, String nomBloc);
    public Bloc affecterBlocAFoyer( String nomBloc, String nomFoyer);


}
