package pfe.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pfe.example.demo.Dao.*;
import pfe.example.demo.Entites.*;

import javax.mail.MessagingException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.mail.MessagingException;

@Service
public class ContributorService {
    @Autowired
    ContributorRepository contributorRepository;
    @Autowired
    ListBlackRepository listBlackRepository;
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    MailSenderService mailSenderService;
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
            try {
                this.mailSenderService.send(account.getEmail(),"Votre compte a été bloquer  ","Attention !");
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Contributor> findAll() {
        return contributorRepository.findAll();
    }
}
