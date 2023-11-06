package tn.esprit.nejd_bedoui_project_4twin7.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.nejd_bedoui_project_4twin7.Models.Universite;
import tn.esprit.nejd_bedoui_project_4twin7.Services.IUniversiteService;
import tn.esprit.nejd_bedoui_project_4twin7.Services.Impl.IUniversiteServiceImpl;

import java.util.List;

@RestController
@RequestMapping("universite")
@RequiredArgsConstructor
public class UniversiteController {
    final public IUniversiteService universiteService;
    @GetMapping("AllUniversite") //affichage
    public List<Universite> getAllUniversite() {
        return universiteService.GetAllUuniversite();
    }

    @PostMapping("addUniversite") // ajouter
    //@ResponseBody
    public Universite AddUniversite(@RequestBody Universite u) {
        return universiteService.AjouterUniversite(u);
    }
    @DeleteMapping("deleteUniversite/{id}")
    public void SupprimerUniversite(@PathVariable Long id) {
        universiteService.SupprimerUniversite(id);
    }
    @PutMapping("update")
    public Universite ModifierUniversite( @RequestBody Universite u) {
        return universiteService.UpdateUniversite(u);
    }
    @PutMapping("affecteruniv/{idfoyer}/{nom}")
    public Universite AffecterUnivAFoyer(@PathVariable long idfoyer, @PathVariable String nom )
    {
        return universiteService.affecterFoyerAUniversite(idfoyer,nom);
    }@PutMapping("deaffecteruniv/{idfoyer}/{idUniversite}")
    public Universite DeaffecterUnivAFoyer(@PathVariable long idfoyer, @PathVariable long idUniversite )
    {
        return universiteService.desaffecterFoyerAUniversite(idfoyer,idUniversite);
    }



}
