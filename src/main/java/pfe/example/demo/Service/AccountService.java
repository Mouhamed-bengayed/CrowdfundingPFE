package pfe.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import pfe.example.demo.Dao.AccountRepository;
import pfe.example.demo.Dao.CommentRepository;
import pfe.example.demo.Entites.Account;
import pfe.example.demo.Entites.Comment;

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

    public Account  getAccountById(Long id){
      return accountRepository.findById(id).orElseThrow();
    }

    public ResponseEntity<?> deleteAccount(Long id){
       Account account=getAccountById(id);
       accountRepository.delete(account);
       return ResponseEntity.ok().build();
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
