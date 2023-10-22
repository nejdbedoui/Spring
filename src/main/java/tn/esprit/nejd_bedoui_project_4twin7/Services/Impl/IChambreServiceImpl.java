package tn.esprit.nejd_bedoui_project_4twin7.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.nejd_bedoui_project_4twin7.Models.Chambre;
import tn.esprit.nejd_bedoui_project_4twin7.Repository.IChambreRepository;
import tn.esprit.nejd_bedoui_project_4twin7.Services.IChambreService;

import java.util.List;

@Service
public class IChambreServiceImpl implements IChambreService {
    @Autowired
    IChambreRepository iChambreRepository;
    @Override
    public List<Chambre> retrieveAllChambres() {
        return iChambreRepository.findAll();
    }

    @Override
    public Chambre addChambre(Chambre c) {
        return iChambreRepository.save(c);
    }

    @Override
    public Chambre updateChambre(Chambre c) {
        Chambre chambre=iChambreRepository.findById(c.getIdChambre()).orElse(null);
        if(chambre!=null){
            chambre.setBloc_chambre(c.getBloc_chambre() == null ? chambre.getBloc_chambre() : c.getBloc_chambre());
            chambre.setNumeroChambre(c.getNumeroChambre() ==null ? chambre.getNumeroChambre() : c.getNumeroChambre());
            chambre.setReservations(c.getReservations() == null ? chambre.getReservations() : c.getReservations());
            chambre.setTypeC(c.getTypeC() == null ? chambre.getTypeC() : c.getTypeC());
            return iChambreRepository.save(chambre);
        }
        return null;
    }

    @Override
    public Chambre retrieveChambre(long idChambre) {
        return iChambreRepository.findById(idChambre).orElse(null);
    }
}
