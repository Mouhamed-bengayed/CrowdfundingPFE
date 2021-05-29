package pfe.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pfe.example.demo.Entites.Account;
import pfe.example.demo.Entites.Contribution;
import pfe.example.demo.Entites.Project;
import pfe.example.demo.Service.ContributionService;

import javax.validation.Path;
import javax.validation.Valid;
import java.util.List;

@CrossOrigin

@RequestMapping("/api/contribution")
@RestController
public class ContributionController {

    @Autowired
    ContributionService contributionService;

    @GetMapping("/list-contribution")
    public List<Contribution> Listcontribution() {
        return contributionService.getAllContribution();
    }

    @PostMapping("/add-contribution/{idAccount}/{idProject}")
    public Contribution addcontribution(@RequestBody @Valid Contribution c1, @PathVariable(name = "idAccount") Long idAccount, @PathVariable(name = "idProject") Long idProject) {
        return contributionService.addContribution(c1, idAccount, idProject);
    }
    @GetMapping("/get-Contibution-by-account/{idAccount}")
    public List<Contribution> getProjectByAccount(@PathVariable("idAccount") Long idAccount) {
        return contributionService.getAllContributionByAccount(idAccount);
    }
}
