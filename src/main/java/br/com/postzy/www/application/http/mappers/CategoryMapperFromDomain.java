package br.com.postzy.www.application.http.mappers;

import br.com.postzy.www.application.http.data.CategoryResponse;
import br.com.postzy.www.application.http.data.PostResponse;
import br.com.postzy.www.domain.Category;
import br.com.postzy.www.domain.Post;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class CategoryMapperFromDomain implements Function<Category, CategoryResponse> {
    @Override
    public CategoryResponse apply(Category category) {
        return new CategoryResponse(
                category.title(),
                category.content(),
                category.slug(),
                category.metaKeywords(),
                category.metaDescription(),
                category.createdAt().toString(),
                category.updatedAt().toString(),
                category.publishedAt().toString()
        );
    }
}


