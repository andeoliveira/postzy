package br.com.postzy.www.domain.service;

import br.com.postzy.www.domain.Category;
import br.com.postzy.www.domain.repository.CategoryRepository;
import br.com.postzy.www.domain.usecase.CategoryUseCase;

public class CategoryService implements CategoryUseCase {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }
}
