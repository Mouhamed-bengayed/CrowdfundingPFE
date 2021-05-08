package pfe.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pfe.example.demo.Dao.AccountRepository;
import pfe.example.demo.Dao.ContributionRepository;
import pfe.example.demo.Dao.ContributorRepository;
import pfe.example.demo.Dao.ProjectRepository;
import pfe.example.demo.Entites.Account;
import pfe.example.demo.Entites.Contribution;
import pfe.example.demo.Entites.Contributor;
import pfe.example.demo.Entites.Project;
import pfe.example.demo.dtos.ProjectState;

import javax.swing.text.html.Option;
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

    public Contribution addContribution(Contribution c1,Long idAccount )
    {   Optional<Account> account=accountRepository.findById(idAccount);
       if(account.isPresent()){
        Contributor  contributor= contributorRepository.findByAccount(account.get());
        if(contributor == null && c1.getProject().getState() != ProjectState.ETATFINAL){
            contributor = new Contributor();
            contributor.setAccount(account.get());
            contributor=contributorRepository.save(contributor);
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



}
