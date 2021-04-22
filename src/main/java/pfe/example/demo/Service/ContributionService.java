package pfe.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pfe.example.demo.Dao.ContributionRepository;
import pfe.example.demo.Entites.Contribution;
import java.util.List;

@Service
public class ContributionService {
    @Autowired
    ContributionRepository contributionRepository;

    public List<Contribution> getAllContribution() { return contributionRepository.findAll(); }

    public Contribution addContribution(Contribution c1)
    {return contributionRepository.save(c1) ;}



}
