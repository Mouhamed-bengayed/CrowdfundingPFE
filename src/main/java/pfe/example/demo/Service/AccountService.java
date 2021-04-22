package pfe.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pfe.example.demo.Dao.AccountRepository;
import pfe.example.demo.Entites.Account;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

@Autowired
    AccountRepository accountRepository;

    public List<Account> getAllAccount(){
        return accountRepository.findAll();
    }

    public Account addAccount(Account a1){
        a1.setValid(false);
        return   accountRepository.save(a1);
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

}
