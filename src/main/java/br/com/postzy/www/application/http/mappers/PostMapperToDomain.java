package br.com.postzy.www.application.http.mappers;

import br.com.postzy.www.application.http.data.PostRequest;
import br.com.postzy.www.domain.Post;
import com.github.slugify.Slugify;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class PostMapperToDomain implements Function<PostRequest, Post> {
    @Override
    public Post apply(PostRequest postRequest) {
        return new Post(
                postRequest.title(),
                postRequest.content(),
                Slugify.builder().build().slugify(postRequest.title()),
                postRequest.metaKeywords(),
                postRequest.metaDescription());
    }
}


