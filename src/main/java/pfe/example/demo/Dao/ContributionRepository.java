package pfe.example.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pfe.example.demo.Entites.Contribution;
@Repository
public interface ContributionRepository extends JpaRepository<Contribution,Long> {

}
