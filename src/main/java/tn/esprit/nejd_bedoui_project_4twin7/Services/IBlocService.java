package tn.esprit.nejd_bedoui_project_4twin7.Services;

import tn.esprit.nejd_bedoui_project_4twin7.Models.Bloc;

import java.util.List;

public interface IBlocService {
    List<Bloc> retrieveBlocs();
    Bloc updateBloc (Bloc bloc);
    Bloc addBloc (Bloc bloc);
    Bloc retrieveBloc (long idBloc);
    void removeBloc (long idBloc);
}
