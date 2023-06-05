package waa.lab1.service;

import waa.lab1.domain.Post;
import waa.lab1.dto.PostDTO;
import waa.lab1.dto.PostV2DTO;
import waa.lab1.dto.UsersDTO;

import java.util.List;
import java.util.Optional;

public interface PostService {

    PostDTO save(PostDTO post);

    List<PostDTO> getAll();

    List<PostDTO> getAllByAuthor(String author);

    void deleteById(long id);

    PostDTO getById(long id);

    PostDTO updatePost(PostDTO postDTO, long id);

    List<PostV2DTO> getAllV2();

    List<PostDTO> getAllByTitle(String title);

    List<UsersDTO> findUserByPostTitle(String title);

}
