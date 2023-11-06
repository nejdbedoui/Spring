package tn.esprit.nejd_bedoui_project_4twin7.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.nejd_bedoui_project_4twin7.Models.Etudiant;
import tn.esprit.nejd_bedoui_project_4twin7.Services.IEtudiantService;
import tn.esprit.nejd_bedoui_project_4twin7.Services.Impl.IEtudiantServiceImpl;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/etudiant")
public class EtudiantController {
    private final IEtudiantService etudiantService;
    @GetMapping("Alletudiant")
    public List<Etudiant> GetAlletudnat(){return etudiantService.GetAllEtudiant();}
    @PostMapping("AddEtudiant")

    public Etudiant AddEtudiant(@RequestBody Etudiant e){
        return etudiantService.AjouterEtudiant(e);
    }
    @PutMapping("UpdateEtudiant")
    public Etudiant UpdateEtudiant(@RequestBody Etudiant e){
        return etudiantService.UpdateEtudiant(e);
    }
    @DeleteMapping("delete/{id}")
    public void SupprimerChambre(@PathVariable long id){
        etudiantService.SupprimerEtdiant(id);}











}
