package tn.esprit.nejd_bedoui_project_4twin7.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.nejd_bedoui_project_4twin7.Services.Impl.IFoyerServiceImpl;

@RestController
@RequestMapping("/api")
public class FoyerController {
    @Autowired
    IFoyerServiceImpl iFoyerService;
}
