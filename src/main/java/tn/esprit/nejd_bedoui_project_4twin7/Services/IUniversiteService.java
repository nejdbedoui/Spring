package tn.esprit.nejd_bedoui_project_4twin7.Services;

import tn.esprit.nejd_bedoui_project_4twin7.Models.Universite;

import java.util.List;

public interface IUniversiteService {
    List<Universite> retrieveAllUniversities();
    Universite addUniversity (Universite u);
    Universite updateUniversity (Universite u);
    Universite retrieveUniversity (long idUniversity);
}
