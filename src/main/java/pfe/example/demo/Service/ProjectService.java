package pfe.example.demo.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pfe.example.demo.Dao.CategoryRepository;
import pfe.example.demo.Dao.ListBlackRepository;
import pfe.example.demo.Dao.PorterRepository;
import pfe.example.demo.Dao.ProjectRepository;
import pfe.example.demo.Entites.Category;
import pfe.example.demo.Entites.ListBlack;
import pfe.example.demo.Entites.Porter;
import pfe.example.demo.Entites.Project;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    ListBlackRepository listBlackRepository;
    @Autowired
    PorterRepository porterRepository;

    public List<Project> getAllProject() {
        return projectRepository.findAll();
    }


    public Project addProject(Project p1) {
        p1.setActif(false);
        return projectRepository.save(p1);
    }


    public Project getProjectById(Long id) {
        return projectRepository.findById(id).orElseThrow();
    }

    public ResponseEntity<?> deleteProject(Long id) {
         Project project = getProjectById(id);
        projectRepository.delete(project);
        return ResponseEntity.ok().build();
    }
    public List<Project> getProjectByNom(String nomProject){
      return   projectRepository.findByNomProject(nomProject);
    }

    public List<Project> getActifProject(){
       return   projectRepository.findByIsActif(true);
   }

    public  List<Project> getAllActiveProjectByCategory(Long idCategory){
        Optional<Category> category=this.categoryRepository.findById(idCategory);
        if(category.isPresent()){
            return projectRepository.findByCategoryAndIsActif(category.get(),true);
        }
        return new ArrayList<>();
    }
    public  List<Project> getAllProjectByPorter(Long idPorter){
        Optional<Porter> porter=this.porterRepository.findById(idPorter);
        if(porter.isPresent()){
            return projectRepository.findByPorter(porter.get());
        }
        return new ArrayList<>();
    }




    public void blockedProject(Long id) {
        Project project = (Project) getProjectById(id) ;
        project.setActif(false);
        projectRepository.save(project);
    }

    public void activateProject(Long id) {
        Project project = (Project) getProjectById(id) ;
        project.setActif(true);
        projectRepository.save(project);

    }



}
