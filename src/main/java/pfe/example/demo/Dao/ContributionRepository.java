package pfe.example.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pfe.example.demo.Entites.Contribution;
import pfe.example.demo.Entites.Contributor;

import java.util.List;

@Repository
public interface ContributionRepository extends JpaRepository<Contribution,Long> {

    List<Contribution> findByContributor(Contributor contributor);
}
