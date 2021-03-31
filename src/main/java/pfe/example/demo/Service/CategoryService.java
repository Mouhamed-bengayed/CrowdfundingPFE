package pfe.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pfe.example.demo.Dao.CategoryRepository;
import pfe.example.demo.Dao.ProjectRepository;

import pfe.example.demo.Entites.Category;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }


    public Category addCategory(Category C1) {
        return categoryRepository.save(C1);
    }


    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow();
    }

    public ResponseEntity<?> deleteCategory(Long id) {
        Category category = getCategoryById(id);
        categoryRepository.delete(category);
        return ResponseEntity.ok().build();
    }


}
