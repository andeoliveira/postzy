package br.com.postzy.www.domain.service;

import br.com.postzy.www.domain.Category;
import br.com.postzy.www.domain.repository.CategoryRepository;
import br.com.postzy.www.domain.usecase.CategoryUseCase;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService implements CategoryUseCase {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category save(Category category) throws Exception {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> listAll(int page, int size) {
        return categoryRepository.listAll(page, size, "title");
    }
}
