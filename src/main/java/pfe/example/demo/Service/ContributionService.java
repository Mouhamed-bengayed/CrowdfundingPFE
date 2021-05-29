package pfe.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pfe.example.demo.Dao.AccountRepository;
import pfe.example.demo.Dao.ContributionRepository;
import pfe.example.demo.Dao.ContributorRepository;
import pfe.example.demo.Dao.ProjectRepository;
import pfe.example.demo.Entites.*;
import pfe.example.demo.dtos.ProjectState;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContributionService {
    @Autowired
    ContributionRepository contributionRepository;
    @Autowired
    ContributorRepository contributorRepository;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    ProjectRepository projectRepository;

    public List<Contribution> getAllContribution() { return contributionRepository.findAll(); }

    public Contribution addContribution(Contribution c1,Long idAccount,Long idProject )
    {   Optional<Account> account=accountRepository.findById(idAccount);
        Optional<Project> project1=projectRepository.findById(idProject);
       if(account.isPresent() && project1.isPresent()){
           c1.setProject(project1.get());
        Contributor  contributor= contributorRepository.findByAccount(account.get());
        if(project1.get().getState() != ProjectState.ETATFINAL){
            if(contributor == null) {
                contributor = new Contributor();
                contributor.setAccount(account.get());
                contributor = contributorRepository.save(contributor);
            }
            Project project=c1.getProject();
            project.setPrixCourant(project.getPrixCourant()+c1.getMontantDeInvestissement());
            if(project.getPrixCourant() >= project.getPrix()){
                project.setState(ProjectState.ETATFINAL);
            }else{
                project.setState(ProjectState.ETATCONTRIBUTION);
            }
            projectRepository.save(project);
        }
        c1.setContributor(contributor);
        return contributionRepository.save(c1) ;
       }
       return null;
    }
    public  List<Contribution> getAllContributionByAccount(Long idAccount){
        Optional<Account> account=this.accountRepository.findById(idAccount);
        if(account.isPresent()){
            Contributor contributor=contributorRepository.findByAccount(account.get());
            if(contributor != null) {
                return contributionRepository.findByContributor(contributor);
            }
        }
        return new ArrayList<>();
    }



}
