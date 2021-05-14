package pfe.example.demo.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pfe.example.demo.Dao.*;
import pfe.example.demo.Entites.*;
import pfe.example.demo.dtos.ProjectState;

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
    @Autowired
    ContributorRepository contributorRepository;
    @Autowired
    VoterRepository voterRepository;
    @Autowired
    AccountRepository accountRepository;

    public List<Project> getAllProject() {
        return projectRepository.findAll();
    }

    public Project addProject(Project p1) {
        p1.setActif(false);
        return projectRepository.save(p1);
    }


    public Project addProject(Project p1,Long idAccount )
    {   Optional<Account> account=accountRepository.findById(idAccount);
        p1.setActif(false);
        p1.setState(ProjectState.ETATINITIAL);
        if(account.isPresent()){
            Porter  porter= porterRepository.findByAccount(account.get());
            if(porter == null){
                porter= new Porter();
                porter.setAccount(account.get());
                porter=porterRepository.save(porter);
            }
            p1.setPorter(porter);
            return projectRepository.save(p1) ;
        }
        return null;
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

    public  List<Project> getAllProjectByAccount(Long idAccount){
        Optional<Account> account=this.accountRepository.findById(idAccount);
        if(account.isPresent()){
            Porter porter=porterRepository.findByAccount(account.get());
            if(porter != null) {
                return projectRepository.findByPorter(porter);
            }
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
    public void voterProject(Long idProject,Long idAccount){
        Optional<Project> project=projectRepository.findById(idProject);
        Optional<Account> account=accountRepository.findById(idAccount);
        if(project.isPresent() && account.isPresent()){
            Vote vote=new Vote();
            vote.setAccount(account.get());
            vote.setProject(project.get());
            voterRepository.save(vote);
        }
    }

    public void supprimerVoteProject(Long idProject,Long idAccount){
        Optional<Project> project=projectRepository.findById(idProject);
        Optional<Account> account=accountRepository.findById(idAccount);
        if(project.isPresent() && account.isPresent()){
            Vote vote=voterRepository.findByAccountAndProject(account.get(),project.get());
            if(vote != null) {
                voterRepository.delete(vote);
            }
        }
    }




}
