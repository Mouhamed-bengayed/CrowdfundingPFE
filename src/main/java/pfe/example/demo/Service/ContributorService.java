package pfe.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pfe.example.demo.Dao.*;
import pfe.example.demo.Entites.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


@Service
public class ContributorService {
    @Autowired
    ContributorRepository contributorRepository;
    @Autowired
    ListBlackRepository listBlackRepository;
    @Autowired
    AccountRepository accountRepository;


    public void activateContributor(Long id) {
        Optional<Contributor> contributor =  contributorRepository.findById(id);
        if(contributor.isPresent()) {
            Account account=contributor.get().getAccount();
            if(account != null) {
                account.setBlocked(false);
                accountRepository.save(account);
            }
            ListBlack listBlack = listBlackRepository.findByContributor(contributor.get());
            this.listBlackRepository.delete(listBlack);
        }
    }



    public void blockedContributor(Long id) {
        Optional<Contributor> contributor =  contributorRepository.findById(id);

        if(contributor.isPresent()) {
            Account account=contributor.get().getAccount();
            if(account != null) {
                account.setBlocked(true);
                accountRepository.save(account);
            }
            ListBlack listBlack = new ListBlack();
            listBlack.setContributor(contributor.get());
            listBlackRepository.save(listBlack);
        }
    }

    public List<Contributor> findAll() {
        return contributorRepository.findAll();
    }
}
