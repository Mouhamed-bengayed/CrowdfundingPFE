package pfe.example.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pfe.example.demo.Entites.Admin;

import java.util.Optional;

public interface AdminRepository  extends JpaRepository<Admin,Long> {

}
