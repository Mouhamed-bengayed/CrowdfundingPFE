package pfe.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pfe.example.demo.Dao.AccountRepository;
import pfe.example.demo.Dao.ContributionRepository;
import pfe.example.demo.Dao.ContributorRepository;
import pfe.example.demo.Entites.Account;
import pfe.example.demo.Entites.Contribution;
import pfe.example.demo.Entites.Contributor;

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

    public List<Contribution> getAllContribution() { return contributionRepository.findAll(); }

    public Contribution addContribution(Contribution c1,Long idAccount )
    {   Optional<Account> account=accountRepository.findById(idAccount);
       if(account.isPresent()){
        Contributor  contributor= contributorRepository.findByAccount(account.get());
        if(contributor == null){
            contributor = new Contributor();
            contributor.setAccount(account.get());
            contributor=contributorRepository.save(contributor);
        }
        c1.setContributor(contributor);
        return contributionRepository.save(c1) ;
       }
       return null;
    }



}
