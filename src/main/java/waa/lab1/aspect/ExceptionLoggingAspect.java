package waa.lab1.aspect;

import lombok.AllArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import waa.lab1.domain.ExceptionLogger;
import waa.lab1.repo.ExceptionLoggerRepository;
import waa.lab1.util.StaticContext;

import java.util.Date;

@Aspect
@Component
@AllArgsConstructor
public class ExceptionLoggingAspect {

    private final StaticContext staticContext;
    private final ExceptionLoggerRepository exceptionLoggerRepository;

    @AfterThrowing(pointcut = "execution(* waa.lab1.service.*.*(..))", throwing = "ex")
    public void logException(JoinPoint joinPoint, Exception ex) {
        var method = joinPoint.getSignature().getDeclaringTypeName().split("\\.");
        var exceptionLogger = ExceptionLogger.builder()
                .exceptionType(ex.getClass().getName())
                .date(new Date())
                .principle(staticContext.getCurrentUser())
                .module(method[method.length-1].replace("ServiceImpl",""))
                .build();
        exceptionLoggerRepository.save(exceptionLogger);
    }

}
