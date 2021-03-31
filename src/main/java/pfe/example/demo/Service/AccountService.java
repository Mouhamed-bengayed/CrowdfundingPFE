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

@Service
public class AccountService {

@Autowired
    AccountRepository accountRepository;

    public List<Account> getAllAccount(){
        return accountRepository.findAll();
    }

    public Account addAccount(Account a1){
        a1.setValid(false);
        accountRepository.findByEmail(a1.getEmail());
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

}
