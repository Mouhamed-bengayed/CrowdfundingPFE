package pfe.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.AbstractPersistable_;
import org.springframework.stereotype.Service;

import pfe.example.demo.Dao.AccountRepository;
import pfe.example.demo.Dao.ContributorRepository;
import pfe.example.demo.Dao.PorterRepository;
import pfe.example.demo.Dao.VoterRepository;
import pfe.example.demo.Entites.*;
import pfe.example.demo.dtos.LoginRequest;
import pfe.example.demo.dtos.UserType;

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
    public List<Account> getAllAccount(){
        return accountRepository.findAll();
    }


    public List<Vote> getAllVoteByAccount(Long idAccount) {
        Optional<Account> account=accountRepository.findById(idAccount);
        if(account.isPresent()){
            return voterRepository.findAllByIdAccount(account.get());
        }else{
            return new ArrayList<>();
        }
    }







    public Account addAccount(Account a1){
        a1.setValid(false);
        Account savedAccount=   accountRepository.save(a1);
        if(savedAccount.getType() == UserType.CONTRIBUTEUR){
            Contributor contributor=new Contributor();
            contributor.setAccount(savedAccount);
            contributorRepository.save(contributor);
        }else if (savedAccount.getType() == UserType.PORTEUR){
            Porter porter=new Porter();
            porter.setAccount(savedAccount);
            porterRepository.save(porter);
        }
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
        }
    }

    public Account signin(LoginRequest login) {
        Optional<Account> account=accountRepository.findByEmailAndPassword(login.getEmail(),login.getPassword());
        if(account.isPresent()){
            return account.get();
        }else{
            return null;
        }
    }
}
