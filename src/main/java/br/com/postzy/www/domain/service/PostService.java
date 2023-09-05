package br.com.postzy.www.domain.service;

import br.com.postzy.www.domain.Post;
import br.com.postzy.www.domain.repository.PostRepository;
import br.com.postzy.www.domain.usecase.PostUseCase;
import com.github.slugify.Slugify;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService implements PostUseCase {
    Logger logger = LoggerFactory.getLogger(PostService.class);
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post publish(Post post) throws Exception {
        logger.info("::Start Post Repository Save::");

        Post postSaved = this.postRepository.save(
                new Post(
                        post.title(),
                        post.content(),
                        Slugify.builder().build().slugify(post.title())
                )
        );

        logger.info("::Finish Post Repository Saved for postId:: "+postSaved.id());
        return postSaved;
    }

    @Override
    public List<Post> listAll(int page, int size) {
        logger.info("::Start Get all Posts::");
        List<Post> allPosts = this.postRepository.listAll(page, size, "title");
        logger.info("::Finish get all Posts:: "+allPosts.size());
        return allPosts;
    }
}
