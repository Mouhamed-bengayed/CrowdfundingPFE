package pfe.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pfe.example.demo.Dao.*;
import pfe.example.demo.Entites.*;

import java.util.Collection;
import java.util.Optional;

@Service
public class ModeratorService {
    @Autowired
    ModeratorRepository moderatorRepository;
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    PorterRepository porterRepository;
    @Autowired
    ListBlackRepository listBlackRepository;
    @Autowired
    ContributorRepository contributorRepository;
    @Autowired
    AccountRepository accountRepository;

    public void blockedPorter(Long id) {
        Porter porter = (Porter) porterRepository.findAllById(id);
        ListBlack listBlack = new ListBlack();
        listBlack.setPorter((Collection<Porter>) porter);
        listBlackRepository.save(listBlack);
    }

    public void blockedContributor(Long id) {
        Contributor contributor = contributorRepository.getOne(id);
        ListBlack listBlack = new ListBlack();
       listBlack.setContributors((Collection<Contributor>) contributor);
        listBlackRepository.save(listBlack);

    }

    public void activatePorter(Long id) {
        Porter porter = (Porter) porterRepository.findAllById(id);
        ListBlack listBlack =listBlackRepository.findByPorteur(porter);
        this.listBlackRepository.delete(listBlack);

    }

    public void activerContibuteur(Long id) {
        // Contributor contributeur=listenoirrepository.getOne(id);
        //  contibuteurRepository.save(contributeur);
        listBlackRepository.deleteById(id);
    }

    public void validInscription(Long id) {
        Optional<Account> account=accountRepository.findById(id);
        if(account.isPresent()) {
            Account account1=account.get();
            account1.setValid(true);
            this.accountRepository.save(account1);
        }
    }

}

