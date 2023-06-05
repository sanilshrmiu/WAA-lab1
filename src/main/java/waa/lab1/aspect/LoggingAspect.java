package waa.lab1.aspect;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import waa.lab1.domain.Logger;
import waa.lab1.repo.LoggerRepository;
import waa.lab1.util.StaticContext;

import java.util.Date;

@Component
@Aspect
@Slf4j
@AllArgsConstructor
public class LoggingAspect {

    private final LoggerRepository loggerRepository;
    private final StaticContext staticContext;
    @Pointcut("execution(* waa.lab1..controller..*(..))")
    public void logPointcutWithExecution(){}

    @Before("logPointcutWithExecution()")
    public void logMethodCallsWithExecutionAdvice(JoinPoint joinPoint) {
        var method = joinPoint.getSignature().getDeclaringTypeName().split("\\.");
        var logger = Logger.builder()
                .date(new Date())
                .principle(staticContext.getCurrentUser())
                .operation(joinPoint.getSignature().getName())
                .module(method[method.length-1].replace("Controller",""))
                .build();
        loggerRepository.save(logger);
    }

}
