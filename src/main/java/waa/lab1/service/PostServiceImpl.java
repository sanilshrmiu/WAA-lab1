package waa.lab1.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import waa.lab1.domain.Post;
import waa.lab1.dto.PostDTO;
import waa.lab1.mapper.PostMapper;
import waa.lab1.repo.PostRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepo postRepo;
    private final PostMapper postMapper;

    @Override
    public Post save(PostDTO post) {
        return postRepo.save(postMapper.toEntity(post));
    }

    @Override
    public List<PostDTO> getAll() {
        return postMapper.toDtoList(postRepo.getAll());
    }

    @Override
    public void deleteById(long id) {
        postRepo.deleteById(id);
    }

    @Override
    public PostDTO getById(long id) {
        return postMapper.toDto(postRepo.getById(id));
    }
}
