package br.com.postzy.www.domain.repository;

import br.com.postzy.www.domain.Category;
import br.com.postzy.www.domain.Post;

import java.util.List;

public interface CategoryRepository {
    Category save(Category category);
    List<Category> listAll(int page, int size, String propertieOrder);
}
