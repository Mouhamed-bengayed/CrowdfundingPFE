package pfe.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pfe.example.demo.Entites.Vote;
import pfe.example.demo.Entites.Project;
import pfe.example.demo.Service.ProjectService;
import pfe.example.demo.Service.VoteService;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/project")
public class ProjectController {

@Autowired
    ProjectService projectService;
@Autowired
    VoteService voteService;

    @DeleteMapping("/delete-project/{idProject}")
    public void deleteProject(@PathVariable("idProject") Long idProject) {
        projectService.deleteProject(idProject);
    }

    @PostMapping("/add-project/{idAccount}")
    public Project addProject(@RequestBody @Valid Project p1,@PathVariable(name = "idAccount") Long idAccount) {
       return projectService.addProject(p1,idAccount);
    }

    @GetMapping("/get-all-project")
    public List<Project> getAllProject() {
        return projectService.getAllProject();
    }

    @GetMapping("/get-project-by-nom/{nomProject}")
    public List<Project> getProjectByNom(@PathVariable("nomProject") String nomProject) {
        return projectService.getProjectByNom(nomProject);
    }
    @GetMapping("/get-project-by-id/{id}")
    public Project getProjectById(@PathVariable("id") Long id) {
        return projectService.getProjectById(id);
    }
    @GetMapping("/get-active-project-by-category/{idCategory}")
    public List<Project> getActiveProjectByCategory(@PathVariable("idCategory") Long idCategory) {
        return projectService.getAllActiveProjectByCategory(idCategory);
    }
    @GetMapping("/get-project-by-porter/{idPorter}")
    public List<Project> getProjectByPorter(@PathVariable("idPorter") Long idPorter) {
        return projectService.getAllProjectByPorter(idPorter);
    }
    @GetMapping("/get-project-by-account/{idAccount}")
    public List<Project> getProjectByAccount(@PathVariable("idAccount") Long idAccount) {
        return projectService.getAllProjectByAccount(idAccount);
    }

    @PutMapping("/active-project/{idProject}")
    public void activePrject(@PathVariable(name = "idProject") Long idProject) {
        projectService.activateProject(idProject);
    }

    @PutMapping("/bloque-project/{idProject}")
    public void bloqueProject(@PathVariable(name = "idProject") Long idProject){
        projectService.blockedProject(idProject);
    }

    @GetMapping("/get-actif-project")
    public List<Project> getActiveProject() {
        return projectService.getActifProject();
    }
/*
    @PutMapping("/voter/{idProject}/{idAccount}")
    public void voterPrject(@PathVariable(name = "idProject") Long idProject,@PathVariable(name = "idAccount") Long idAccount) {
        projectService.voterProject(idProject,idAccount);
    }*/

    @DeleteMapping("/annuler-voter/{idProject}/{idAccount}")
    public void supprimerVoteProject(@PathVariable(name = "idProject") Long idProject,@PathVariable(name = "idAccount") Long idAccount) {
        projectService.supprimerVoteProject(idProject,idAccount);
    }

    @GetMapping("/get-all-voter/{idProject}")
    public List<Vote> numbervoteProject(@PathVariable(name = "idProject") Long idProject) {
      return   voteService.getAllVote(idProject);
    }



}



