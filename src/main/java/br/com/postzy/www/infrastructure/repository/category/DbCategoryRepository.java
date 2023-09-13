package br.com.postzy.www.infrastructure.repository.category;

import br.com.postzy.www.domain.Category;
import br.com.postzy.www.domain.repository.CategoryRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DbCategoryRepository implements CategoryRepository {
    private final DbCategoryJpaReposity dbCategoryJpaReposity;

    public DbCategoryRepository(DbCategoryJpaReposity dbCategoryJpaReposity) {
        this.dbCategoryJpaReposity = dbCategoryJpaReposity;
    }

    @Override
    public Category save(Category category) throws Exception {
        try {
            CategoryEntity categoryEntity = dbCategoryJpaReposity.save(new CategoryEntity(category));
            return new Category(
                    categoryEntity.getTitle(),
                    categoryEntity.getContent(),
                    categoryEntity.getSlug(),
                    categoryEntity.getCreatedAt().toLocalDateTime(),
                    categoryEntity.getUpdatedAt().toLocalDateTime(),
                    categoryEntity.getPublishedAt().toLocalDateTime());
        } catch (DataAccessException e) {
            throw new Exception("Error on insert category in database");
        }

    }

    @Override
    public List<Category> listAll(int page, int size, String propertieOrder) {
        PageRequest pageRequest = PageRequest.of(
                page,
                size,
                Sort.Direction.ASC,
                propertieOrder);
        List<CategoryEntity> allCategories = dbCategoryJpaReposity.findAll(pageRequest).getContent();
        return allCategories.stream()
                .map(c -> new Category(
                        c.getId(),
                        c.getParentId(),
                        c.getTitle(),
                        c.getContent(),
                        c.getSlug(),
                        c.getCreatedAt().toLocalDateTime(),
                        c.getUpdatedAt().toLocalDateTime(),
                        c.getPublishedAt().toLocalDateTime()
                ))
                .collect(Collectors.toList());
    }
}
