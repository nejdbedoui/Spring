package tn.esprit.nejd_bedoui_project_4twin7.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.nejd_bedoui_project_4twin7.Models.Universite;
import tn.esprit.nejd_bedoui_project_4twin7.Repository.IUniversiteRepository;
import tn.esprit.nejd_bedoui_project_4twin7.Services.IUniversiteService;

import java.util.List;

@Service
public class IUniversiteServiceImpl implements IUniversiteService {
    @Autowired
    IUniversiteRepository iUniversiteRepository;
    @Override
    public List<Universite> retrieveAllUniversities() {
        return iUniversiteRepository.findAll();
    }

    @Override
    public Universite addUniversity(Universite u) {
        return iUniversiteRepository.save(u);
    }

    @Override
    public Universite updateUniversity(Universite u) {
        Universite universite=iUniversiteRepository.findById(u.getIdUniversite()).orElse(null);
        if(universite!=null){
            universite.setNomUniversite(u.getNomUniversite() == null ? universite.getNomUniversite() : u.getNomUniversite());
            universite.setAdresse(u.getAdresse() ==null ? universite.getAdresse() : u.getAdresse());
            universite.setFoyer(u.getFoyer() == null ? universite.getFoyer() : u.getFoyer());
            return iUniversiteRepository.save(universite);
        }
        return null;
    }

    @Override
    public Universite retrieveUniversity(long idUniversity) {
        return iUniversiteRepository.findById(idUniversity).orElse(null);
    }
}
