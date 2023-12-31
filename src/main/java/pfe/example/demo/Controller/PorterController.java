package pfe.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pfe.example.demo.Entites.Porter;
import pfe.example.demo.Service.PorterService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/porter")
public class PorterController {
@Autowired
PorterService porterService;
    @PutMapping("/active-porter/{idPorter}")
    public void activePorter(@PathVariable(name = "idPorter") Long idPorter) {
        porterService.activatePorter(idPorter);
    }

    @PutMapping("/bloque-porter/{idPorter}")
    public void blockedPorter(@PathVariable(name = "idPorter") Long idPorter){
        porterService.blockedPorter(idPorter);
    }

   @GetMapping("/find-all")
    public List<Porter> getAll(){
      return porterService.getAllPorter();
   }

}
