package tn.esprit.nejd_bedoui_project_4twin7.Services.Impl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.nejd_bedoui_project_4twin7.Models.Foyer;
import tn.esprit.nejd_bedoui_project_4twin7.Models.Universite;
import tn.esprit.nejd_bedoui_project_4twin7.Repository.IFoyerRepository;
import tn.esprit.nejd_bedoui_project_4twin7.Repository.IUniversiteRepository;
import tn.esprit.nejd_bedoui_project_4twin7.Services.IUniversiteService;

import java.util.List;

@Service
@AllArgsConstructor
public class IUniversiteServiceImpl implements IUniversiteService {
    IUniversiteRepository universiteRepository;
    IFoyerRepository foyerRepository;

    @Override
    public Universite AjouterUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite UpdateUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public void SupprimerUniversite(long idUniversite) {
        universiteRepository.deleteById(idUniversite);
    }

    @Override
    public Universite GetUniversite(long idUniversite) {
        return universiteRepository.findById(idUniversite).orElse(null);
    }

    @Override
    public List<Universite> GetAllUuniversite() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite findbyNomuniv(String nom) {
        return universiteRepository.findByNomUniversite(nom);
    }

    @Override
    @Transactional
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {
        System.out.println(idFoyer);
        Foyer f = foyerRepository.findById(idFoyer).orElse(null);
        Universite uni = universiteRepository.findByNomUniversite(nomUniversite);
        if (f != null && uni != null) {
            uni.setFoyer(f);
            return uni;

        }
        return null;
    }


    @Override
    @Transactional
    public Universite desaffecterFoyerAUniversite(long idFoyer, long idUniversite) {
        Foyer f = foyerRepository.findById(idFoyer).orElse(null);
        Universite u = universiteRepository.findById(idUniversite).orElse(null);
        if (f != null && u != null) {
            u.setFoyer(null);
            return u;
        }

        return null;
    }


}
