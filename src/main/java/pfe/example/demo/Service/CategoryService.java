package pfe.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pfe.example.demo.Dao.CategoryRepository;


import pfe.example.demo.Entites.Category;

import java.util.List;
import java.util.Optional;

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
        Optional<Category> category = categoryRepository.findById(id);
        if(category.isPresent()){
            return category.get();
        }else {
            return null;
        }
    }

    public void deleteCategory(Long id) {
        Category category = getCategoryById(id);
        categoryRepository.delete(category);
    }


}
