package waa.lab1.repo;

import org.springframework.stereotype.Repository;
import waa.lab1.domain.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PostRepoImpl implements PostRepo{

    List<Post> db = new ArrayList<>();

    private Long id = 1L;

    @Override
    public Post save(Post post) {
        post.setId(id);
        id++;
        db.add(post);
        return post;
    }

    @Override
    public List<Post> getAll() {
        return db;
    }

    @Override
    public List<Post> getAllByAuthor(String author) {
        return db.stream().filter(p -> p.getAuthor().equals(author)).collect(Collectors.toList());
    }

    @Override
    public void deleteById(long id) {
        Post post = getById(id);
        db.remove(post);
    }

    @Override
    public Post getById(long id) {
        return db.stream()
                .filter(p -> id==p.getId())
                .findAny()
                .orElse(null);
    }
}
