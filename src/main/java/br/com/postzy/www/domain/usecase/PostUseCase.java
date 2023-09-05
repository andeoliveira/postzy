package br.com.postzy.www.domain.usecase;

import br.com.postzy.www.domain.Post;

import java.util.List;

public interface PostUseCase {
    Post publish(Post post) throws Exception;
    List<Post> listAll(int page, int size);
}
