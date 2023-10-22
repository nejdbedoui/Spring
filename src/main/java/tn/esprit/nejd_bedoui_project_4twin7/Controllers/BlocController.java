package tn.esprit.nejd_bedoui_project_4twin7.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.nejd_bedoui_project_4twin7.Models.Bloc;
import tn.esprit.nejd_bedoui_project_4twin7.Services.Impl.IBlocServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BlocController {
    @Autowired
    IBlocServiceImpl iBlocService;
    @GetMapping(value = "/getAll")
    public List<Bloc> retrieveBlocs(){
        return iBlocService.retrieveBlocs();
    }

}
