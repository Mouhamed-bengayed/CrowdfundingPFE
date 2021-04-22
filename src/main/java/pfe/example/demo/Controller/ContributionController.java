package pfe.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pfe.example.demo.Entites.Account;
import pfe.example.demo.Entites.Contribution;
import pfe.example.demo.Service.ContributionService;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin

@RequestMapping("/api/contribution")
@RestController
public class ContributionController {

@Autowired
    ContributionService contributionService;

    @GetMapping("/list-contribution")
    public List<Contribution> ListAccount() {
        return contributionService.getAllContribution();
    }
    @PostMapping("/add-contribution")
    public Contribution addAccount(@RequestBody @Valid Contribution A1){
        return  contributionService.addContribution(A1);
    }
}
