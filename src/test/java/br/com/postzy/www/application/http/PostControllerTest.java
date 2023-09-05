package br.com.postzy.www.application.http;

import br.com.postzy.www.application.http.data.PostRequest;
import br.com.postzy.www.application.http.mappers.PostMapperFromDomain;
import br.com.postzy.www.application.http.mappers.PostMapperToDomain;
import br.com.postzy.www.domain.Post;
import br.com.postzy.www.domain.usecase.PostUseCase;
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
public class PostControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PostUseCase postUseCase;
    @MockBean
    private PostMapperToDomain postMapperToDomain;
    @MockBean
    private PostMapperFromDomain postMapperFromDomain;
    @Test
    public void whenCreatedPostThenReturnStatusOk() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        PostRequest postRequest = new PostRequest("Title", "Content");
        Post post = new Post("TestTitle", "TestContent", "testTitle");

        Mockito.when(postUseCase.publish(Mockito.any())).thenReturn(post);

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/post/new")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(postRequest)))
                        .andExpect(MockMvcResultMatchers.status().isCreated());

    }
    @Test
    public void whenPublishNullPointerThenReturnInternalserverError() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Mockito.when(postUseCase.publish(Mockito.any())).thenThrow(NullPointerException.class);
        PostRequest postRequest = new PostRequest(null, null);
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/post/new")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(postRequest)))
                .andExpect(MockMvcResultMatchers.status().isInternalServerError());

    }
    @Test
    public void whenFindedPostListThenReturnStatusOk() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/post/all"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
