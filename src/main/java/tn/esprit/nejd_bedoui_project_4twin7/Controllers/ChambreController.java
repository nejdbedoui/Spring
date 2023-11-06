package tn.esprit.nejd_bedoui_project_4twin7.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.nejd_bedoui_project_4twin7.Models.Chambre;
import tn.esprit.nejd_bedoui_project_4twin7.Models.TypeChambre;
import tn.esprit.nejd_bedoui_project_4twin7.Services.IChambreService;
import tn.esprit.nejd_bedoui_project_4twin7.Services.Impl.IChambreServiceImpl;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/chambre")
public class ChambreController {
    private final IChambreService chambreService;
    @GetMapping("GetAllChambre")
    public List<Chambre> GetAllChambre(){return chambreService.GetAllChambres();}
    @PostMapping("Addchambre")
    public Chambre AjoutChambre(@RequestBody Chambre c){
        return chambreService.AjoutChambre(c);
    }
    @PutMapping("Update")
    public Chambre Updatechambre(@RequestBody Chambre c ){
        return chambreService.UpdateChambre(c);
    }
    @DeleteMapping("deleteChambre/{id}")
    public void SupprimerChambre(@PathVariable long id){
        chambreService.SupprimerChambre(id);
    }
    @GetMapping("getChambresParNomBloc/{nomBloc}")
    public List<Chambre> getChambresParNomBloc(@PathVariable String nomBloc){
        return chambreService.getChambresParNomBloc(nomBloc);

    }

    @GetMapping("nbChambreParTypeEtBloc/{type}/{idbloc}")
    public long nbChambreParTypeEtBloc(@PathVariable TypeChambre type, @PathVariable long idbloc){
        return chambreService.nbChambreParTypeEtBloc(type,idbloc);

    }

    @GetMapping("getChambresNonReserveParNomFoyerEtTypeChambre/{nomFoyer}/{type}")
    public List<Chambre> getChambresNonReserveParNomFoyerEtTypeChambre(@PathVariable String nomFoyer, @PathVariable TypeChambre type){
        return chambreService.getChambresNonReserveParNomFoyerEtTypeChambre(nomFoyer,type);

    }

}
