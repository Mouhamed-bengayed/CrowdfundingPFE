package pfe.example.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pfe.example.demo.Entites.Account;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,Long> {
 Account findByEmail(String email);

    Optional<Account> findByEmailAndPassword(String email,String password);
}
