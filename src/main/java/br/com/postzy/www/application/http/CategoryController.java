package br.com.postzy.www.application.http;

import br.com.postzy.www.application.http.data.CategoryRequest;
import br.com.postzy.www.application.http.data.CategoryResponse;
import br.com.postzy.www.application.http.data.PostResponse;
import br.com.postzy.www.application.http.mappers.CategoryMapperFromDomain;
import br.com.postzy.www.application.http.mappers.CategoryMapperToDomain;
import br.com.postzy.www.domain.Category;
import br.com.postzy.www.domain.Post;
import br.com.postzy.www.domain.usecase.CategoryUseCase;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/category")
public class CategoryController {
    Logger logger = LoggerFactory.getLogger(CategoryController.class);
    private final CategoryUseCase categoryUseCase;
    private final CategoryMapperToDomain mapperToDomain;
    private final CategoryMapperFromDomain mapperFromDomain;
    public CategoryController(CategoryUseCase categoryUseCase, CategoryMapperToDomain mapToDomain, CategoryMapperFromDomain mapperFromDomain) {
        this.categoryUseCase = categoryUseCase;
        this.mapperToDomain = mapToDomain;
        this.mapperFromDomain = mapperFromDomain;
    }
    @PostMapping("/new")
    public HttpEntity<CategoryResponse> publish(@Valid @RequestBody CategoryRequest categoryRequest) throws Exception {
        logger.info("::Start process of saving category::");
        Category category = categoryUseCase.save(mapperToDomain.apply(categoryRequest));
        logger.info("Finish process of saving category, categoryId:"+ category.id());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(mapperFromDomain.apply(category));
    }
    @GetMapping("/all")
    public ResponseEntity<List<CategoryResponse>> all() {
        logger.info("::Start get list all categories::");
        List<Category> allCategories = categoryUseCase.listAll(0, 5);
        logger.info("::Returning get list all posts, size total:: "+allCategories.size());
        return ResponseEntity.status(HttpStatus.OK).body(
                allCategories.stream()
                        .map(i-> mapperFromDomain.apply(i))
                        .collect(Collectors.toList())
        );
    }
}
