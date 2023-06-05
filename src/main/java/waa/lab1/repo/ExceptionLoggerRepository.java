package waa.lab1.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import waa.lab1.domain.ExceptionLogger;

@Repository
public interface ExceptionLoggerRepository extends JpaRepository<ExceptionLogger, Long> {
}
