package pfe.example.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pfe.example.demo.Entites.Category;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
