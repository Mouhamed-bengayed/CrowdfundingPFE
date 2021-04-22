package pfe.example.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pfe.example.demo.Entites.*;

import java.util.Collection;

@Repository
public interface ListBlackRepository extends JpaRepository<ListBlack,Long> {


    ListBlack findByPorter(Porter porter);

    ListBlack findByContributor(Contributor contributor);


}

