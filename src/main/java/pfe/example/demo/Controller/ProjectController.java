package pfe.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pfe.example.demo.Entites.Project;
import pfe.example.demo.Service.ProjectService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProjectController {

@Autowired
    ProjectService projectService;

    @DeleteMapping("/deleteProject")
    public void deleteProject(Long id) {
        projectService.deleteProject(id);
    }

    @PostMapping("/addProject")
    public Project addProject(@RequestBody @Valid Project p1) {
       return projectService.addProject(p1);
    }

    @GetMapping("/getAllProject")
    public List<Project> getAllProject() {
        return projectService.getAllProject();
    }

    @GetMapping("/getProjectByNom")
    public Project getProjectByNom(@RequestBody @Valid String nom) {
        return projectService.getProjectByNom(nom);
    }
}
