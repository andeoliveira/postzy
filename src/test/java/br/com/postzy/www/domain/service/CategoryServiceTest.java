package br.com.postzy.www.domain.service;

import br.com.postzy.www.domain.Category;
import br.com.postzy.www.domain.repository.CategoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = CategoryService.class, loader= AnnotationConfigContextLoader.class)
public class CategoryServiceTest {
    @MockBean
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryService categoryService;

    @Test
    public void mustSaveTheCategory() throws Exception {
        Category category = new Category("TestTitle", "TestContent", "testTitle");
        Mockito.when(categoryRepository.save(Mockito.any())).thenReturn(category);
        Assertions.assertNotNull(categoryService.save(category));
    }

    @Test
    public void mustListAllCategories() throws Exception {

        Category category1 = new Category("Nacional", "Futebol Brasileiro", "categoria-nacional");
        Category category2 = new Category("Europeu", "Futebol Europeu", "categoria-europeu");
        List<Category> mockCategories = new ArrayList<>();
        mockCategories.add(category1);
        mockCategories.add(category2);

        Mockito.when(categoryRepository.listAll(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyString())).thenReturn(mockCategories);

        List<Category> categories = categoryService.listAll(1, 5);

        Assertions.assertNotNull(categories);
        Assertions.assertEquals(categories, mockCategories);
    }
}