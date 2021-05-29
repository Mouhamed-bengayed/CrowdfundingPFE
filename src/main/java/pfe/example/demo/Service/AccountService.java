package pfe.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.AbstractPersistable_;
import org.springframework.stereotype.Service;

import pfe.example.demo.Dao.*;
import pfe.example.demo.Entites.*;
import pfe.example.demo.dtos.LoginRequest;
import pfe.example.demo.dtos.UserType;

import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    ContributorRepository contributorRepository;
    @Autowired
    PorterRepository porterRepository;
    @Autowired
    VoterRepository voterRepository;
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    ListBlackRepository listBlackRepository;
    @Autowired
    MailSenderService mailSenderService;

    public List<Account> getAllAccount(){
        return accountRepository.findAll();
    }


    public List<Vote> getAllVoteByProject(Long idProject) {
        Optional<Project> project=projectRepository.findById(idProject);
        if(project.isPresent()){
            return voterRepository.findByProject(project.get());
        }else{
            return new ArrayList<>();
        }
    }


    public Account addAccount(Account a1){
        a1.setValid(false);
        Account savedAccount=   accountRepository.save(a1);

      /*  if(savedAccount.getType() == UserType.CONTRIBUTEUR){
            Contributor contributor=new Contributor();
            contributor.setAccount(savedAccount);
            contributorRepository.save(contributor);
        }else if (savedAccount.getType() == UserType.PORTEUR){
            Porter porter=new Porter();
            porter.setAccount(savedAccount);
            porterRepository.save(porter);
        }

       */
        return savedAccount;
    }


    public Account deleteAccount(Long id){
        Optional<Account> account = accountRepository.findById(id);
        if(account.isPresent()){
            return account.get();
        }else {
            return null;
        }
    }
    public void validInscription(Long id) {
        Optional<Account> account=accountRepository.findById(id);
        if(account.isPresent()) {
            Account account1=account.get();

            account1.setValid(true);
            this.accountRepository.save(account1);
            try {
                this.mailSenderService.send(account.get().getEmail(),"Votre compte a été activé  ","merci pour votre inscription");
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }
    }

    public Account signin(LoginRequest login) {
        Optional<Account> account=accountRepository.findByEmailAndPasswordAndValid(login.getEmail(),login.getPassword(),true);
        if(account.isPresent()){
            Porter porter=porterRepository.findByAccount(account.get());
            ListBlack listBlack = null;
            if(porter != null) {
                 listBlack = listBlackRepository.findByPorter(porter);
            }
            if(listBlack == null) {
                return account.get();
            }
        }
            return null;
    }
}
