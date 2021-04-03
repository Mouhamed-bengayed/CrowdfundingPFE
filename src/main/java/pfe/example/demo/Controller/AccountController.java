package pfe.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pfe.example.demo.Entites.Account;
import pfe.example.demo.Service.AccountService;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/Account")
@RestController
public class AccountController {
    @Autowired
    AccountService accountService;
    @GetMapping("/list-account")
    public List<Account> ListAccount() {
        return accountService.getAllAccount();
    }
    @DeleteMapping("/delete-account/{idAccount}")
    public void deleteAccount(@PathVariable("idAccount") Long idAccount) {
        accountService.deleteAccount(idAccount);
    }
    @PostMapping("/add-account")
    public Account addAccount(@RequestBody @Valid Account A1){
        return  accountService.addAccount(A1);
    }

}
