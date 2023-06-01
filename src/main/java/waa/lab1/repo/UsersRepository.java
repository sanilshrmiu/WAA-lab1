package waa.lab1.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import waa.lab1.domain.Users;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    @Query("SELECT u FROM Users u WHERE SIZE(u.posts) > 1")
    List<Users> findByPostsGreaterThan();

}
