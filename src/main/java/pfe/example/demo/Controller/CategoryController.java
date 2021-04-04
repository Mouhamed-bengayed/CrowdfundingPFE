package pfe.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pfe.example.demo.Entites.Category;
import pfe.example.demo.Service.CategoryService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @GetMapping("/list-categories")
    public List<Category> ListCategory() {
        return categoryService.getAllCategories();
    }
    @DeleteMapping("/delete-category/{idCategory}")
    public void deleteCategory(@PathVariable("idCategory") Long idCategory) { categoryService.deleteCategory(idCategory); }
    @PostMapping("/add-category")
    public Category addCategory(@RequestBody @Valid Category c1){
      return   categoryService.addCategory(c1);
    }

}
