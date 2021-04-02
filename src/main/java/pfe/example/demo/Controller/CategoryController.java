package pfe.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pfe.example.demo.Entites.Category;
import pfe.example.demo.Service.CategoryService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @GetMapping("/listCategories")
    public List<Category> ListCategory() {
        return categoryService.getAllCategories();
    }
    @DeleteMapping("/deleteCategory")
    public void deleteCategory(@RequestBody @Valid Long c1) {
        categoryService.deleteCategory(c1);
    }
    @PostMapping("/addCategory")
    public Category addCategory(@RequestBody @Valid Category c1){
      return   categoryService.addCategory(c1);
    }

}
