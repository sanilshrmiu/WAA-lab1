package waa.lab1.mapper;

import org.mapstruct.Mapper;
import waa.lab1.domain.Post;
import waa.lab1.dto.PostDTO;
import waa.lab1.dto.PostV2DTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {

    Post toEntity(PostDTO dto);

    PostDTO toDto(Post post);

    List<Post> toEntityList(List<PostDTO> postDTOS);

    List<PostDTO> toDtoList(List<Post> postList);

    List<PostV2DTO> toDtoListV2(List<Post> postList);

}
