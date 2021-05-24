package pfe.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pfe.example.demo.Entites.Contributor;
import pfe.example.demo.Service.ContributorService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/contributor")
public class ContributorController {
    @Autowired
    ContributorService contributorService;

    @PutMapping("/active-contributor/{idContributor}")
    public void activeContributor(@PathVariable(name = "idContributor") Long idContributor) {
        contributorService.activateContributor(idContributor);
    }

    @PutMapping("/bloque-contributor/{idContributor}")
    public void blockedContributor(@PathVariable(name = "idContributor") Long idContributor) {
        contributorService.blockedContributor(idContributor);
    }

    @GetMapping("/find-all")
    public List<Contributor> findAll() {
        return contributorService.findAll();
    }

}
