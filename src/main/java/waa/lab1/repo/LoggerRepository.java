package waa.lab1.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import waa.lab1.domain.Logger;

@Repository
public interface LoggerRepository extends JpaRepository<Logger,Long> {
}
