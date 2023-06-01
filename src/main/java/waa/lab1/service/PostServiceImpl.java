package waa.lab1.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import waa.lab1.domain.Post;
import waa.lab1.dto.PostDTO;
import waa.lab1.dto.PostV2DTO;
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
    public List<PostDTO> getAllByAuthor(String author) {
        return postMapper.toDtoList(postRepo.getAllByAuthor(author));
    }

    @Override
    public void deleteById(long id) {
        postRepo.deleteById(id);
    }

    @Override
    public PostDTO getById(long id) {
        return postMapper.toDto(postRepo.getById(id));
    }

    @Override
    public PostDTO updatePost(PostDTO postDTO, long id) {
        var post = postRepo.getById(id);
        post.setContent(postDTO.content());
        post.setAuthor(postDTO.author());
        post.setTitle(postDTO.title());
        return postMapper.toDto(post);
    }

    @Override
    public List<PostV2DTO> getAllV2() {
        return postMapper.toDtoListV2(postRepo.getAll());
    }

}
