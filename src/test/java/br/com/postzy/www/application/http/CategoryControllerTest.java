package br.com.postzy.www.application.http;

import br.com.postzy.www.application.http.data.CategoryRequest;
import br.com.postzy.www.application.http.mappers.CategoryMapperFromDomain;
import br.com.postzy.www.application.http.mappers.CategoryMapperToDomain;
import br.com.postzy.www.domain.Category;
import br.com.postzy.www.domain.usecase.CategoryUseCase;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PostController.class)
public class CategoryControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CategoryUseCase categoryUseCase;
    @MockBean
    private CategoryMapperToDomain categoryMapperToDomain;
    @MockBean
    private CategoryMapperFromDomain categoryMapperFromDomain;

    @Test
    public void whenCreatedCategoryThenReturnStatusOk() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Mockito.when(categoryUseCase.save(Mockito.any())).thenReturn(
                new Category("TestTitle", "TestContent", "testTitle"));

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/category/new")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(
                                new CategoryRequest("Title", "Content"))))
                        .andExpect(MockMvcResultMatchers.status().isCreated());

    }
    @Test
    public void whenPublishNullPointerThenReturnInternalserverError() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Mockito.when(categoryUseCase.save(Mockito.any())).thenThrow(NullPointerException.class);

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/category/new")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(
                                new CategoryRequest("Title", "Title"))))
                .andExpect(MockMvcResultMatchers.status().isInternalServerError());

    }
    @Test
    public void whenFindedPostListThenReturnStatusOk() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/category/all"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
