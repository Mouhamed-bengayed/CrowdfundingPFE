package pfe.example.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pfe.example.demo.Entites.Account;
import pfe.example.demo.Entites.Contributor;
import pfe.example.demo.Entites.Project;

import java.util.List;

@Repository
public interface ContributorRepository extends JpaRepository<Contributor,Long> {


    Contributor findByAccount(Account account);
}
