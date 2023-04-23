package xyz.onegrid.coreapi.web.rest.publicapi.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import xyz.onegrid.coreapi.web.rest.publicapi.api.Category;

@Controller
public class CategoryController {

    private static final Map<Long, Category> categoryDataStore = new HashMap<>();

    static {
        categoryDataStore.put(1L, new Category(1L, "Category 1", 10));
        categoryDataStore.put(2L, new Category(2L, "Category 2", 20));
        categoryDataStore.put(3L, new Category(3L, "Category 3", 30));
        categoryDataStore.put(4L, new Category(4L, "Category 4", 40));
    }

    public Category getCategory(Long id) {
        return categoryDataStore.get(id);
    }

    public Category createCategory(Category category) {
        categoryDataStore.put(category.getId(), category);
        return category;
    }

    public Category updateCategory(Category category) {
        categoryDataStore.put(category.getId(), category);
        return category;
    }

    public Category deleteCategory(Long id) {
        return categoryDataStore.remove(id);
    }

    public Map<Long, Category> getAllCategories() {
        return categoryDataStore;
    }
}
