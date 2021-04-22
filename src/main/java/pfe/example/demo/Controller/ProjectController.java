package pfe.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pfe.example.demo.Entites.Category;
import pfe.example.demo.Entites.Project;
import pfe.example.demo.Service.ProjectService;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/project")
public class ProjectController {

@Autowired
    ProjectService projectService;

    @DeleteMapping("/delete-project/{idProject}")
    public void deleteProject(@PathVariable("idProject") Long idProject) {
        projectService.deleteProject(idProject);
    }

    @PostMapping("/add-project")
    public Project addProject(@RequestBody @Valid Project p1) {
       return projectService.addProject(p1);
    }

    @GetMapping("/get-llProject")
    public List<Project> getAllProject() {
        return projectService.getAllProject();
    }

    @GetMapping("/get-project-by-nom/{nomProject}")
    public Project getProjectByNom(@PathVariable("nomProject") String nomProject) {
        return projectService.getProjectByNom(nomProject);
    }
    @GetMapping("/get-project-by-category/{idCategory}")
    public List<Project> getProjectByNomCategory(@PathVariable("idCategory") Long idCategory) {
        return projectService.getAllProjectByCategory(idCategory);
    }



    @PutMapping("/active-project/{idProject}")
    public void activePrject(@PathVariable(name = "idProject") Long idProject) {
        projectService.activateProject(idProject);
    }

    @PutMapping("/bloque-project/{idPorter}")
    public void bloqueProject(@PathVariable(name = "idProject") Long idProject){
        projectService.blockedProject(idProject);
    }

}
