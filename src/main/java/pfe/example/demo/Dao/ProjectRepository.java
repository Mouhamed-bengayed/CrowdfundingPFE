package pfe.example.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pfe.example.demo.Entites.Account;
import pfe.example.demo.Entites.Category;
import pfe.example.demo.Entites.Porter;
import pfe.example.demo.Entites.Project;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {

   List<Project> findByNomProject(String nom);
    List<Project> findByCategoryAndIsActif(Category category,boolean actif);
    List<Project> findByPorter(Porter porter);
    List<Project> findByIsActif(boolean actif);
}
