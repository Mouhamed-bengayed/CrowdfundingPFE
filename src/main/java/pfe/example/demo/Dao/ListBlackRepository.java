package pfe.example.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pfe.example.demo.Entites.ListBlack;

@Repository
public interface ListBlackRepository extends JpaRepository<ListBlack,Long> {


}

