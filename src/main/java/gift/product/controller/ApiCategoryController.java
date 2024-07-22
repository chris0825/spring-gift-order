package gift.product.controller;

import gift.product.model.Category;
import gift.product.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/category")
public class ApiCategoryController {

    private final CategoryService categoryService;

    @Autowired
    public ApiCategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<String> registerCategory(@Valid @RequestBody Category category) {
        System.out.println("[CategoryController] registerCategory()");
        categoryService.registerCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body("Category registered successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCategory(@PathVariable Long id, @Valid @RequestBody Category category) {
        System.out.println("[CategoryController] updateCategory()");
        categoryService.updateCategory(new Category(id, category.getName()));
        return ResponseEntity.status(HttpStatus.CREATED).body("Category registered successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
        System.out.println("[CategoryController] deleteCategory()");
        categoryService.deleteCategory(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Category deleted successfully");
    }

}
