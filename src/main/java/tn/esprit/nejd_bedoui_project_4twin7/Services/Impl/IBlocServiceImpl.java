package tn.esprit.nejd_bedoui_project_4twin7.Services.Impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.nejd_bedoui_project_4twin7.Models.Bloc;
import tn.esprit.nejd_bedoui_project_4twin7.Models.Chambre;
import tn.esprit.nejd_bedoui_project_4twin7.Models.Foyer;
import tn.esprit.nejd_bedoui_project_4twin7.Repository.IBlocRepository;
import tn.esprit.nejd_bedoui_project_4twin7.Repository.IChambreRepository;
import tn.esprit.nejd_bedoui_project_4twin7.Repository.IFoyerRepository;
import tn.esprit.nejd_bedoui_project_4twin7.Services.IBlocService;

import java.util.List;

@Service
@AllArgsConstructor
public class IBlocServiceImpl implements IBlocService {
    IFoyerRepository foyerRepository;
    IBlocRepository blocRepository;
    IChambreRepository chambreRepository;
    @Override
    public Bloc AjouterBloc(Bloc b) {
        return blocRepository.save(b) ;
    }

    @Override
    public Bloc UpdateBloc(Bloc b) {
        return blocRepository.save(b);
    }

    @Override
    public void SupprimerBloc(long idBloc) {
        blocRepository.deleteById(idBloc);
    }

    @Override
    public Bloc GetBloc(long idBloc) {
        return blocRepository.findById(idBloc).orElse(null);
    }

    @Override
    public List<Bloc> GetAllBlocs() {
        return blocRepository.findAll();
    }
    @Transactional
    @Override
    public Bloc affecterChambresABloc(List<Long> numChambre, String nomBloc) {
        Bloc b = blocRepository.findByNomBloc(nomBloc);
        for(Long id : numChambre){
            Chambre c = chambreRepository.findById(id).orElse(null);
            c.setBlocChambre(b);
        }
        return b;
    }
    @Transactional
    @Override
    public Bloc affecterBlocAFoyer(String nomBloc, String nomFoyer) {
        Bloc b = blocRepository.findByNomBloc(nomBloc);
        Foyer f = foyerRepository.findByNomFoyer(nomFoyer);
        b.setFoyer(f);
        return b;
    }
}
