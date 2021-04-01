package pfe.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pfe.example.demo.Dao.*;
import pfe.example.demo.Entites.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class ContributorService {
    @Autowired
    ContributorRepository contributorRepository;
    @Autowired
    ListBlackRepository listBlackRepository;

    public void activateContributor(Long id) {
        Contributor contributor = (Contributor) contributorRepository.getOne(id);
        ListBlack listBlack = listBlackRepository.findByContributor(contributor);
        this.listBlackRepository.deleteById(id);
    }

    public void blockedContributor(Long id) {
        Contributor contributor = contributorRepository.getOne(id);
        ListBlack listBlack = new ListBlack();
        listBlack.setContributor((Collection<Contributor>) contributor);
        listBlackRepository.save(listBlack);

    }
}
