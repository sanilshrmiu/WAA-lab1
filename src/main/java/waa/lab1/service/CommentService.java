package waa.lab1.service;

import org.springframework.stereotype.Service;
import waa.lab1.dto.CommentDTO;

import java.util.List;

@Service
public interface CommentService {
    CommentDTO postComment(CommentDTO commentDTO, Long postId);

    List<CommentDTO> findByPost(Long postId);

    CommentDTO findByPostAndCommentId(Long postId, Long commentId);

}
