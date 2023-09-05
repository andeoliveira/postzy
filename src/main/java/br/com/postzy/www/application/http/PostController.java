package br.com.postzy.www.application.http;

import br.com.postzy.www.application.http.data.PostRequest;
import br.com.postzy.www.application.http.data.PostResponse;
import br.com.postzy.www.application.http.mappers.PostMapperFromDomain;
import br.com.postzy.www.application.http.mappers.PostMapperToDomain;
import br.com.postzy.www.domain.Post;
import br.com.postzy.www.domain.usecase.PostUseCase;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/post")
public class PostController {
    Logger logger = LoggerFactory.getLogger(RestController.class);
    private final PostUseCase postUseCase;
    private final PostMapperToDomain mapperToDomain;
    private final PostMapperFromDomain mapperFromDomain;
    public PostController(PostUseCase postUseCase, PostMapperToDomain mapToDomain, PostMapperFromDomain mapFromDomain) {
        this.postUseCase = postUseCase;
        this.mapperToDomain = mapToDomain;
        this.mapperFromDomain = mapFromDomain;
    }
    @PostMapping("/new")
    public HttpEntity<PostResponse> publish(@Valid @RequestBody PostRequest postRequest) throws Exception {
        logger.info("::Start process of saving post::");
        Post post = postUseCase.publish(mapperToDomain.apply(postRequest));
        logger.info("Finish process of saving post, postId:"+ post.id());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(mapperFromDomain.apply(post));
    }
    @GetMapping("/all")
    public ResponseEntity<List<PostResponse>> all() {
        logger.info("::Start get list all posts::");
        List<Post> allPosts = postUseCase.listAll(0, 5);
        logger.info("::Returning get list all posts, size total:: "+allPosts.size());
        return ResponseEntity.status(HttpStatus.OK).body(
                allPosts.stream()
                        .map(i-> mapperFromDomain.apply(i))
                        .collect(Collectors.toList())
        );
    }
}
