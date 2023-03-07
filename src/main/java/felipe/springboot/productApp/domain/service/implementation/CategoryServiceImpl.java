package felipe.springboot.productApp.domain.service.implementation;

import com.sun.jdi.request.DuplicateRequestException;
import felipe.springboot.productApp.common.dto.CategoryDto;
import felipe.springboot.productApp.domain.entity.Category;
import felipe.springboot.productApp.domain.service.CategoryService;
import felipe.springboot.productApp.persistence.repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    private void categoryExists(String name) {
        if (categoryRepository.existsByName(name)) {
            throw new DuplicateRequestException("the name of category is already register");
        }
    }

    @Override
    public List<Category> findAllCategories() {
        return (List<Category>) categoryRepository.findAll();
    }

    @Override
    public Category findCategoryById(Short id) {
        Category category = categoryRepository.findCategoryById(id);
        if (category == null) {
            throw new EntityNotFoundException("the category with id: " + id + "is not found");
        }
        return category;
    }

    @Override
    public Category createCategory(CategoryDto categoryDto) {
        Category category = new Category();
        this.categoryExists(categoryDto.getName());
        BeanUtils.copyProperties(categoryDto, category);
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(CategoryDto categoryDto) {
        Category category = new Category();
        BeanUtils.copyProperties(categoryDto, category);
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategoryById(Short id) {
        this.findCategoryById(id);
        categoryRepository.deleteById(id);
    }
}