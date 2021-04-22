package pfe.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pfe.example.demo.Dao.*;
import pfe.example.demo.Entites.*;

import java.util.Collection;


@Service
public class ContributorService {
    @Autowired
    ContributorRepository contributorRepository;
    @Autowired
    ListBlackRepository listBlackRepository;

    public void activateContributor(Long idContributeur) {
        Contributor contributor = (Contributor) contributorRepository.getOne(idContributeur);
        ListBlack listBlack = listBlackRepository.findByContributor(contributor);
        this.listBlackRepository.delete(listBlack);
    }

    public void blockedContributor(Long id) {
        Contributor contributor = contributorRepository.getOne(id);
        ListBlack listBlack = new ListBlack();
        listBlack.setContributor(contributor);
        listBlackRepository.save(listBlack);
    }
}
