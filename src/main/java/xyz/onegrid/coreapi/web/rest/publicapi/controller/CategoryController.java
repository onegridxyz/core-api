package xyz.onegrid.coreapi.web.rest.publicapi.controller;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.onegrid.coreapi.web.rest.publicapi.api.Category;

@RestController
@RequestMapping("/api")
public class CategoryController {

    private static final Map<Long, Category> categoryDataStore = new HashMap<>();

    static {
        categoryDataStore.put(1L, new Category(1L, "Category 1", 10));
        categoryDataStore.put(2L, new Category(2L, "Category 2", 20));
        categoryDataStore.put(3L, new Category(3L, "Category 3", 30));
        categoryDataStore.put(4L, new Category(4L, "Category 4", 40));
    }

    @GetMapping("/categories/{id}")
    public Category getCategory(@PathVariable Long id) {
        return categoryDataStore.get(id);
    }

    @PostMapping("/categories")
    public Category createCategory(@RequestBody Category category) {
        categoryDataStore.put(category.getId(), category);
        return category;
    }

    @PutMapping("/categories")
    public Category updateCategory(@RequestBody Category category) {
        categoryDataStore.put(category.getId(), category);
        return category;
    }

    @DeleteMapping("/categories/{id}")
    public Category deleteCategory(@PathVariable Long id) {
        return categoryDataStore.remove(id);
    }

    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return categoryDataStore.values().stream().sorted(Comparator.comparing(Category::getId)).collect(Collectors.toList());
    }
}
