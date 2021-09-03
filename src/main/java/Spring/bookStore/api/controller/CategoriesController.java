package Spring.bookStore.api.controller;

import Spring.bookStore.business.abstracts.CategoryService;
import Spring.bookStore.core.utilities.results.DataResult;
import Spring.bookStore.entities.concretes.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin
public class CategoriesController {

    private CategoryService categoryService;

    @Autowired
    public CategoriesController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/getAllCategory")
    public DataResult<List<Category>> getAllCategory(){
        return this.categoryService.getAllCategory();
    }

    @GetMapping("findById")
    public DataResult<List<Category>> findById(int categoryId){
        return this.categoryService.findById(categoryId);
    }
}
