package br.com.postzy.www.domain.usecase;

import br.com.postzy.www.domain.Category;
import br.com.postzy.www.domain.Post;

import java.util.List;

public interface CategoryUseCase {
    Category save(Category category) throws Exception;
    List<Category> listAll(int page, int size);
}
