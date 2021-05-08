package pfe.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pfe.example.demo.Entites.Account;
import pfe.example.demo.Entites.Vote;
import pfe.example.demo.Service.AccountService;
import pfe.example.demo.dtos.LoginRequest;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin

@RequestMapping("/api/Account")
@RestController
public class AccountController {
    @Autowired
    AccountService accountService;
    @GetMapping("/list-account")
    public List<Account> ListAccount() {
        return accountService.getAllAccount();
    }
    @GetMapping("/list-vote-project/{idProject}")
    public List<Vote> getAllVoteByProject(@PathVariable("idProject") Long idProject) {
        return accountService.getAllVoteByProject(idProject);
    }
    @DeleteMapping("/delete-account/{idAccount}")
    public void deleteAccount(@PathVariable("idAccount") Long idAccount) { accountService.deleteAccount(idAccount); }
    @PostMapping("/add-account")
    public Account addAccount(@RequestBody @Valid Account A1){
        return  accountService.addAccount(A1);
    }

    @PutMapping("/validate-account/{idAccount}")
    public void validInscription(@PathVariable("idAccount") Long idAccount) {
         accountService.validInscription(idAccount);
    }
    @PostMapping("/signin")
    public Account signin(@RequestBody @Valid LoginRequest login){
        return  accountService.signin(login);
    }
}
