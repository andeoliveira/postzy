package br.com.postzy.www.application.http.mappers;

import br.com.postzy.www.application.http.data.PostResponse;
import br.com.postzy.www.domain.Post;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class PostMapperFromDomain implements Function<Post, PostResponse> {
    @Override
    public PostResponse apply(Post post) {
        return new PostResponse(
                post.title(),
                post.content(),
                post.slug(),
                post.metaKeywords(),
                post.metaKeywords(),
                post.createdAt().toString(),
                post.updatedAt().toString(),
                post.publishedAt().toString()
        );
    }
}


