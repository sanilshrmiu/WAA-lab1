package waa.lab1.mapper;

import org.mapstruct.Mapper;
import waa.lab1.domain.Comment;
import waa.lab1.dto.CommentDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    Comment toEntity(CommentDTO commentDTO);

    CommentDTO toDto(Comment comment);

    List<Comment> toEntityList(List<CommentDTO> dtos);

    List<CommentDTO> toDtoList(List<Comment> comments);

}
