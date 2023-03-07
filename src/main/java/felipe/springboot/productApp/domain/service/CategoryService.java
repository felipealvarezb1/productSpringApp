package felipe.springboot.productApp.domain.service;

import felipe.springboot.productApp.common.dto.CategoryDto;
import felipe.springboot.productApp.domain.entity.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAllCategories();

    Category findCategoryById(Short id);

    Category createCategory(CategoryDto categoryDto);

    Category updateCategory(CategoryDto categoryDto);

    void deleteCategoryById(Short id);
}