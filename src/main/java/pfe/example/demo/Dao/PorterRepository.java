package pfe.example.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pfe.example.demo.Entites.Account;
import pfe.example.demo.Entites.Porter;

import java.util.List;

@Repository
public interface PorterRepository extends JpaRepository<Porter,Long> {

    void deleteById(long id);

    List<Porter> findAllById(Long id);

    Porter findByAccount(Account account);
}
