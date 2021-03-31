package pfe.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pfe.example.demo.Dao.*;
import pfe.example.demo.Entites.*;

import java.util.Collection;

@Service
public class ModeratorService {
    @Autowired
    ModeratorRepository moderatorRepository;
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    PorterRepository porterRepository;
    @Autowired
    ListBlackRepository listBlackRepository;
    @Autowired
    ContributorRepository contributorRepository;

    public void blockedPorter(Long id) {
        Porter porter = (Porter) porterRepository.findAllById(id);
        ListBlack listBlack = new ListBlack();
        listBlack.setPorter((Collection<Porter>) porter);
        listBlackRepository.save(listBlack);
    }

    public void blockedContributor(Long id) {
        Contributor contributor = contributorRepository.getOne(id);
        ListBlack listBlack = new ListBlack();
      //  listBlack.setPorter((Collection<Contributor>) contributor);
        listBlackRepository.save(listBlack);

    }

    public void activatePorter(Long id) {
      //  Porter porter= (Porter) listBlackRepository.findById(id);
       // projectRepository.save(porter);
       // listBlackRepository.deleteById(id);
    }

    public void activerContibuteur(Long id) {
        // Contributor contributeur=listenoirrepository.getOne(id);
        //  contibuteurRepository.save(contributeur);
        listBlackRepository.deleteById(id);
    }

   // public Boolean validInscription() {

   // }

}

