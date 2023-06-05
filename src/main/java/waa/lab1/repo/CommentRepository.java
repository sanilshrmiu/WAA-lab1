package waa.lab1.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import waa.lab1.domain.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("from Comment c join Post p where p.id = :postId and c.id = :commentId")
    Comment findByPostIdAndCommentId(@Param("postId") Long postId, @Param("commentId") Long commentId);

}
