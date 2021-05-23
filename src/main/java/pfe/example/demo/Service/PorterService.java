package pfe.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pfe.example.demo.Dao.AccountRepository;
import pfe.example.demo.Dao.ListBlackRepository;
import pfe.example.demo.Dao.PorterRepository;
import pfe.example.demo.Entites.Account;
import pfe.example.demo.Entites.ListBlack;
import pfe.example.demo.Entites.Porter;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class PorterService {
@Autowired
PorterRepository porterRepository;
@Autowired
ListBlackRepository listBlackRepository;
@Autowired
    AccountRepository accountRepository;

   public void blockedPorter(Long id) {
       Optional<Porter> porter =  porterRepository.findById(id);

       if(porter.isPresent()) {
           Account account=porter.get().getAccount();
            if(account != null) {
                account.setBlocked(true);
                accountRepository.save(account);
            }
           ListBlack listBlack = new ListBlack();
           listBlack.setPorter(porter.get());
           listBlackRepository.save(listBlack);
       }
    }

    public void activatePorter(Long id) {
        Optional<Porter> porter =  porterRepository.findById(id);
        if(porter.isPresent()) {
            Account account=porter.get().getAccount();
            if(account != null) {
                account.setBlocked(false);
                accountRepository.save(account);
            }
            ListBlack listBlack = listBlackRepository.findByPorter(porter.get());
            this.listBlackRepository.delete(listBlack);
        }
    }

    public List<Porter> getAllPorter() {
       return porterRepository.findAll();
    }
}
