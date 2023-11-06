package tn.esprit.nejd_bedoui_project_4twin7.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.nejd_bedoui_project_4twin7.Models.Foyer;
import tn.esprit.nejd_bedoui_project_4twin7.Services.IFoyerService;
import tn.esprit.nejd_bedoui_project_4twin7.Services.Impl.IFoyerServiceImpl;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/foyer")
public class FoyerController {
    private final IFoyerService foyerService;
    @GetMapping("Allfoyer")
    public List<Foyer> getAllFoyer() {
        return foyerService.GetAllfoyer();
    }

    @PostMapping("addfoyer")

    public Foyer AddFoyer(@RequestBody Foyer f) {
        return foyerService.Ajouterfoyer(f);
    }
    @DeleteMapping("deletefoyer/{id}")
    public void Supprimerfoyer(@PathVariable Long id) {
        foyerService.SupprimeFoyer(id);
    }
    @PutMapping("update")
    public Foyer ModifierFoyer( @RequestBody Foyer f) {
        return foyerService.Updatefoyer(f);
    }

    @GetMapping("getfoyer/{id}")
    public Foyer getfoyerByid(@PathVariable long id){
        return foyerService.Getfoyer(id);
    }

    @PostMapping("affecter/{id}")
    public Foyer ajouterFoyerEtAffecterAUniversite(@RequestBody Foyer f,@PathVariable Long id){
        return foyerService.ajouterFoyerEtAffecterAUniversite(f,id);
    }


}
