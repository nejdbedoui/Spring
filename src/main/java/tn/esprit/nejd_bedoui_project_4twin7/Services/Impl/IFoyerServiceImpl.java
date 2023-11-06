package tn.esprit.nejd_bedoui_project_4twin7.Services.Impl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.nejd_bedoui_project_4twin7.Models.Bloc;
import tn.esprit.nejd_bedoui_project_4twin7.Models.Foyer;
import tn.esprit.nejd_bedoui_project_4twin7.Models.Universite;
import tn.esprit.nejd_bedoui_project_4twin7.Repository.IBlocRepository;
import tn.esprit.nejd_bedoui_project_4twin7.Repository.IFoyerRepository;
import tn.esprit.nejd_bedoui_project_4twin7.Repository.IUniversiteRepository;
import tn.esprit.nejd_bedoui_project_4twin7.Services.IFoyerService;
import tn.esprit.nejd_bedoui_project_4twin7.Services.IUniversiteService;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class IFoyerServiceImpl implements IFoyerService {
    final  IFoyerRepository foyerRepository;
    final IUniversiteRepository universiteRepository;
    IBlocRepository iBlocRepository;
    IBlocServiceImpl iBlocService;
    IUniversiteService iUniversiteService;
    @Override
    public Foyer Ajouterfoyer(Foyer f) {
        System.out.println(f);
        return foyerRepository.save(f);
    }

    @Override
    public Foyer Updatefoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public void SupprimeFoyer(long idfoyer) {
        foyerRepository.deleteById(idfoyer);

    }

    @Override
    public Foyer Getfoyer(long idfoyer) {
        return foyerRepository.findById(idfoyer).orElse(null);
    }

    @Override
    public List<Foyer> GetAllfoyer() {
        return foyerRepository.findAll();
    }

    @Override
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {
        Foyer f=this.Ajouterfoyer(foyer);
        Set<Bloc> blocs=foyer.getBlocs();
        iBlocRepository.saveAll(blocs);
        for(Bloc b:blocs){
            iBlocService.affecterBlocAFoyer(b.getNomBloc(),f.getNomFoyer());
        }
        Universite u=universiteRepository.findById(idUniversite).orElse(null);
        iUniversiteService.affecterFoyerAUniversite(f.getIdFoyer(),u.getNomUniversite());
        return f;
    }


}
