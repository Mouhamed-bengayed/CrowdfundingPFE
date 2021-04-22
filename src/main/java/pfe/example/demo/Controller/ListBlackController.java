package pfe.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pfe.example.demo.Dao.ListBlackRepository;
import pfe.example.demo.Entites.Account;
import pfe.example.demo.Entites.ListBlack;

import pfe.example.demo.Service.ListBlackService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/List-black")
public class ListBlackController {

//@Autowired
//ListBlackService listBlackService;

    //@GetMapping("/list-Black")
    //public List<ListBlack> ListBlack() {
    //    return listBlackService.getAllListeBlack();
  //  }
}
