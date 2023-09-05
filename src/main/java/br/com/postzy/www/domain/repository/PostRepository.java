package br.com.postzy.www.domain.repository;

import br.com.postzy.www.domain.Post;
import java.util.List;

public interface PostRepository {
    Post save(Post post) throws Exception;
    List<Post> listAll(int page, int size, String propertieOrder);
}
