package tn.esprit.nejd_bedoui_project_4twin7.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.nejd_bedoui_project_4twin7.Models.Bloc;
import tn.esprit.nejd_bedoui_project_4twin7.Repository.IBlocRepository;
import tn.esprit.nejd_bedoui_project_4twin7.Services.IBlocService;

import java.util.List;

@Service
public class IBlocServiceImpl implements IBlocService {
    @Autowired
    IBlocRepository iBlocRepository;
    @Override
    public List<Bloc> retrieveBlocs() {
        return iBlocRepository.findAll();
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        Bloc bloc1=iBlocRepository.findById(bloc.getIdBloc()).orElse(null);
        if(bloc1!=null){
            bloc1.setCapaciteBloc(bloc.getCapaciteBloc());
            bloc1.setNomBloc(bloc.getNomBloc()==null ? bloc1.getNomBloc() : bloc.getNomBloc());
            bloc1.setChambres(bloc.getChambres() == null ? bloc1.getChambres() : bloc.getChambres());
            bloc1.setFoyer(bloc.getFoyer() == null ? bloc1.getFoyer() : bloc.getFoyer());
            return iBlocRepository.save(bloc1);
        }
        return null;
    }

    @Override
    public Bloc addBloc(Bloc bloc) {
        return iBlocRepository.save(bloc);
    }

    @Override
    public Bloc retrieveBloc(long idBloc) {
        return iBlocRepository.findById(idBloc).orElse(null);
    }

    @Override
    public void removeBloc(long idBloc) {
        Bloc bloc=iBlocRepository.findById(idBloc).orElse(null);
        if(bloc!=null)
        iBlocRepository.delete(bloc);
    }
}
