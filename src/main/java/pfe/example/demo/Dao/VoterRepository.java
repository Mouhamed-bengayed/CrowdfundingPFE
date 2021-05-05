package pfe.example.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pfe.example.demo.Entites.Account;
import pfe.example.demo.Entites.Contributor;
import pfe.example.demo.Entites.Project;
import pfe.example.demo.Entites.Vote;

import java.util.List;

public interface VoterRepository extends JpaRepository<Vote,Long> {

    Vote findByAccountAndProject(Account account, Project project);



    List<Vote> findByProject(Project project);

    List<Vote> findAllByIdAccount(Account idAccount);
}
