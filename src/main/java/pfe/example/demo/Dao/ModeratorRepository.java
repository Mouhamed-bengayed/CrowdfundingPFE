package pfe.example.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pfe.example.demo.Entites.Moderator;

@Repository
public interface ModeratorRepository extends JpaRepository<Moderator,Long> {



}
