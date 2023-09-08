package br.com.postzy.www.application.http.mappers;

import br.com.postzy.www.application.http.data.CategoryRequest;
import br.com.postzy.www.application.http.data.PostRequest;
import br.com.postzy.www.domain.Category;
import br.com.postzy.www.domain.Post;
import com.github.slugify.Slugify;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class CategoryMapperToDomain implements Function<CategoryRequest, Category> {
    @Override
    public Category apply(CategoryRequest categoryRequest) {
        return new Category(
                categoryRequest.title(),
                categoryRequest.content(),
                Slugify.builder().build().slugify(categoryRequest.title())
        );
    }
}


