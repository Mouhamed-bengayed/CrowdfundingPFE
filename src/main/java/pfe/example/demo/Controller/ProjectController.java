package pfe.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pfe.example.demo.Entites.Project;
import pfe.example.demo.Service.ProjectService;

import javax.validation.Valid;
import java.util.List;

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

    @GetMapping("/get-AllProject")
    public List<Project> getAllProject() {
        return projectService.getAllProject();
    }

    @GetMapping("/get-project-ByNom")
    public Project getProjectByNom(@RequestBody @Valid String nom) {
        return projectService.getProjectByNom(nom);
    }
}
