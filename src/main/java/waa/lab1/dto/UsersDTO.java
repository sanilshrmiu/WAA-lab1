package waa.lab1.dto;

import waa.lab1.domain.Post;

import java.util.List;

public record UsersDTO(Long id, String name, List<Post> posts) {
}
