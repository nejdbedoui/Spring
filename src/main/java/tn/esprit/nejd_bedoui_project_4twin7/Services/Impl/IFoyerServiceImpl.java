package tn.esprit.nejd_bedoui_project_4twin7.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.nejd_bedoui_project_4twin7.Models.Foyer;
import tn.esprit.nejd_bedoui_project_4twin7.Repository.IFoyerRepository;
import tn.esprit.nejd_bedoui_project_4twin7.Services.IFoyerService;

import java.util.List;

@Service
public class IFoyerServiceImpl implements IFoyerService {
    @Autowired
    IFoyerRepository iFoyerRepository;
    @Override
    public List<Foyer> retrieveAllFoyers() {
        return iFoyerRepository.findAll();
    }

    @Override
    public Foyer addFoyer(Foyer f) {
        return iFoyerRepository.save(f);
    }

    @Override
    public Foyer updateFoyer(Foyer f) {
        Foyer foyer=iFoyerRepository.findById(f.getIdFoyer()).orElse(null);
        if(foyer!=null){
            foyer.setCapaciteFoyer(f.getCapaciteFoyer() == null ? foyer.getCapaciteFoyer() : f.getCapaciteFoyer());
            foyer.setNomFoyer(f.getNomFoyer() ==null ? foyer.getNomFoyer() : f.getNomFoyer());
            foyer.setBlocs(f.getBlocs() == null ? foyer.getBlocs() : f.getBlocs());
            foyer.setUniversite(f.getUniversite() == null ? foyer.getUniversite() : f.getUniversite());
        return iFoyerRepository.save(foyer);
        }
        return null;
    }

    @Override
    public Foyer retrieveFoyer(long idFoyer) {
        return iFoyerRepository.findById(idFoyer).orElse(null);
    }

    @Override
    public void removeFoyer(long idFoyer) {
        Foyer foyer=iFoyerRepository.findById(idFoyer).orElse(null);
        if(foyer!=null)
            iFoyerRepository.delete(foyer);
    }
}
