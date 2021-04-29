package pfe.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import pfe.example.demo.Dao.*;
import pfe.example.demo.Entites.*;

import java.util.List;

@Service
public class ListBlackService {

    @Autowired
    ListBlackRepository listBlackRepository;



    public List<ListBlack> getAllListeBlack() {
        return listBlackRepository.findAll();
    }

    public List<ListBlack> getAllListeBlackContributeur() {
        return  listBlackRepository.findByContributorNotNull();
    }

    public List<ListBlack> getAllListeBlackPorteur() {
        return  listBlackRepository.findByPorterNotNull();
    }

    // public void addListBlack(ListBlack listBlack) {
      //  listBlackRepository.save(listBlack);
    //}


   // public void activateAccount(Long id) {
     //   Account account=(Account) accountRepository.getOne((id));
       // ListBlack listBlack = listBlackRepository.findByAccount(account);
        //this.listBlackRepository.deleteById(id);
   // }

   // public void blockedAccount(Long id) {
     //   Account account=(Account) accountRepository.getOne((id));
     //   ListBlack listBlack = new ListBlack();
    //    listBlack.set((Collection<Account>) account);
    //    listBlackRepository.save(listBlack);

    }




