package pfe.example.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pfe.example.demo.Entites.Account;
import pfe.example.demo.Entites.Porter;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,Long> {

    Optional<Account> findByEmailAndPassword(String email,String password);

    Optional<Account> findByEmailAndPasswordAndValid(String email, String password, boolean valid);

}
