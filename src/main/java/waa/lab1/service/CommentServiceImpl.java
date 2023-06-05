package waa.lab1.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import waa.lab1.dto.CommentDTO;
import waa.lab1.mapper.CommentMapper;
import waa.lab1.repo.CommentRepository;
import waa.lab1.repo.PostRepository;

import java.util.List;

@Transactional
@AllArgsConstructor
@Service
public class CommentServiceImpl implements CommentService{

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final CommentMapper commentMapper;

    @Override
    public CommentDTO postComment(CommentDTO commentDTO, Long postId){
        var comment = commentMapper.toEntity(commentDTO);
        commentRepository.save(comment);
        var post = postRepository.findById(postId);
        if (post.isPresent()){
            var updatePost = post.get();
            updatePost.getComments().add(comment);
            postRepository.save(updatePost);
        }
        return commentMapper.toDto(comment);
    }

    @Override
    public List<CommentDTO> findByPost(Long postId) {
        var post = postRepository.findById(postId);
        if (post.isPresent()){
            return commentMapper.toDtoList(post.get().getComments());
        }
        return null;
    }

    @Override
    public CommentDTO findByPostAndCommentId(Long postId, Long commentId) {
        return commentMapper.toDto(commentRepository.findByPostIdAndCommentId(postId,commentId));
    }

}
