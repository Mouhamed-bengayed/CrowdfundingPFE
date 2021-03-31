package pfe.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pfe.example.demo.Entites.Account;
import pfe.example.demo.Service.AccountService;

import java.util.List;

@RequestMapping("/api/account")
@RestController
public class AccountController {
    @Autowired
    AccountService accountService;

    @GetMapping("/listAccount")
    public List<Account> ListAccount() {
        return accountService.getAllAccount();
    }

    @DeleteMapping("/deleteAccount")
    public void deleteAccount(Long c1) {
        accountService.deleteAccount(c1);
    }
    @PostMapping("/addAccount")
    public Account addAccount(Account A1){
        return  accountService.addAccount(A1);
    }

}
