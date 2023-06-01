package waa.lab1.repo;

import waa.lab1.domain.Post;

import java.util.List;
import java.util.Optional;

public interface PostRepo {

    Post save(Post post);

    List<Post> getAll();

    List<Post> getAllByAuthor(String author);

    void deleteById(long id);

    Post getById(long id);

}
