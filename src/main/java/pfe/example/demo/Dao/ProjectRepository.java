package pfe.example.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pfe.example.demo.Entites.Category;
import pfe.example.demo.Entites.Project;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {

    Project findByNomProject(String nom);
    List<Project> findByCategory(Category category);

}
