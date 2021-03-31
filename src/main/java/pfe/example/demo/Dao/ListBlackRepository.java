package pfe.example.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pfe.example.demo.Entites.Contributor;
import pfe.example.demo.Entites.ListBlack;
import pfe.example.demo.Entites.Porter;

@Repository
public interface ListBlackRepository extends JpaRepository<ListBlack,Long> {


    ListBlack findByPorter(Porter porter);

    ListBlack findByContributor(Contributor contributor);
}

