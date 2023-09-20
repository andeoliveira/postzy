package br.com.postzy.www.infrastructure.repository.post;

import br.com.postzy.www.domain.Post;
import br.com.postzy.www.domain.repository.PostRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DbPostRepository implements PostRepository {
    private final DbPostJpaReposity dbPostJpaReposity;

    public DbPostRepository(DbPostJpaReposity dbPostJpaReposity) {
        this.dbPostJpaReposity = dbPostJpaReposity;
    }

    @Override
    public Post save(Post post) throws Exception {
        try {
            PostEntity postEntity = dbPostJpaReposity.save(new PostEntity(post));
            return new Post(
                    postEntity.getTitle(),
                    postEntity.getContent(),
                    postEntity.getSlug(),
                    postEntity.getMetaKeywords(),
                    postEntity.getMetaDescription(),
                    postEntity.getCreatedAt().toLocalDateTime(),
                    postEntity.getUpdatedAt().toLocalDateTime(),
                    postEntity.getPublishedAt().toLocalDateTime());
        } catch (DataAccessException e) {
            throw new Exception("Error on insert post in database");
        }
    }

    @Override
    public List<Post> listAll(int page, int size, String propertieOrder) {
        PageRequest pageRequest = PageRequest.of(
                page,
                size,
                Sort.Direction.ASC,
                propertieOrder);
        List<PostEntity> allPosts = dbPostJpaReposity.findAll(pageRequest).getContent();
        return allPosts.stream()
                .map(p -> new Post(
                        p.getId(),
                        p.getTitle(),
                        p.getContent(),
                        p.getSlug(),
                        p.getMetaKeywords(),
                        p.getMetaDescription(),
                        p.getCreatedAt().toLocalDateTime(),
                        p.getUpdatedAt().toLocalDateTime(),
                        p.getPublishedAt().toLocalDateTime()
                ))
                .collect(Collectors.toList());
    }
}
