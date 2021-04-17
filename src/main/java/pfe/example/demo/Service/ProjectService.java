package pfe.example.demo.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pfe.example.demo.Dao.ProjectRepository;
import pfe.example.demo.Entites.Category;
import pfe.example.demo.Entites.Project;
import java.util.List;

@Service
public class ProjectService {
    @Autowired
    ProjectRepository projectRepository;

    public List<Project> getAllProject() {
        return projectRepository.findAll();
    }


    public Project addProject(Project p1) { return projectRepository.save(p1);}


    public Project getProjectById(Long id) {
        return projectRepository.findById(id).orElseThrow();
    }

    public ResponseEntity<?> deleteProject(Long id) {
         Project project = getProjectById(id);
        projectRepository.delete(project);
        return ResponseEntity.ok().build();
    }
    public Project getProjectByNom(String nomProject){
      return   projectRepository.findByNomProject(nomProject);
    }
    public  List<Project> getAllProjectByCategory(Category category){
        return projectRepository.findByCategory(category);
    }
}
