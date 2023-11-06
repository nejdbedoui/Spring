package tn.esprit.nejd_bedoui_project_4twin7.Services.Impl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.nejd_bedoui_project_4twin7.Models.Bloc;
import tn.esprit.nejd_bedoui_project_4twin7.Models.Chambre;
import tn.esprit.nejd_bedoui_project_4twin7.Models.Foyer;
import tn.esprit.nejd_bedoui_project_4twin7.Models.TypeChambre;
import tn.esprit.nejd_bedoui_project_4twin7.Repository.IBlocRepository;
import tn.esprit.nejd_bedoui_project_4twin7.Repository.IChambreRepository;
import tn.esprit.nejd_bedoui_project_4twin7.Repository.IFoyerRepository;
import tn.esprit.nejd_bedoui_project_4twin7.Services.IChambreService;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Service
public class IChambreServiceImpl implements IChambreService {
    IChambreRepository chambreRepository;
    IBlocRepository blocRepository;
    IFoyerRepository foyerRepository;

    @Override
    public Chambre AjoutChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public Chambre UpdateChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public void SupprimerChambre(long idChambre) {
        chambreRepository.deleteById(idChambre);
    }

    @Override
    public Chambre GetChambre(long idChambre) {
        return chambreRepository.findById(idChambre).orElse(null);
    }

    @Override
    public List<Chambre> GetAllChambres() {
        return chambreRepository.findAll();
    }

    @Override
    public List<Chambre> getChambresParNomBloc(String nomBloc) {
        Bloc b = blocRepository.findByNomBloc(nomBloc);
        List<Chambre> chambres = new ArrayList<>();
        for(Chambre c : b.getChambres()){
            chambres.add(c);

        }
        return chambres;
    }

    @Override
    public long nbChambreParTypeEtBloc(TypeChambre type, long idBloc) {
        Bloc b = blocRepository.findById(idBloc).orElse(null);
        int nbrchambre = 0;
        for(Chambre c : b.getChambres()){
            if (c.getTypeC()==type) {
                nbrchambre++;
            }
        }



        return  nbrchambre;
    }

    @Override
    public List<Chambre> getChambresNonReserveParNomFoyerEtTypeChambre(String nomFoyer, TypeChambre type) {

        Foyer foyer = foyerRepository.findByNomFoyer(nomFoyer);
        List<Chambre> chambre = new ArrayList<>();
        List<Bloc> blocs = blocRepository.findByFoyer(foyer);
        for (Bloc b : blocs) {

            chambre.addAll(chambreRepository.findByTypeCAndBlocChambreAndReservations(type,b,null));
        }




        return chambre;
    }


}
