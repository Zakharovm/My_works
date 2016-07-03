package app;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    private Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);


    @Around("execution(* parser.UtilOperation.*(..))")
    public Object utilPerformOperation(ProceedingJoinPoint pjp) throws Throwable {
        LOGGER.info("LogAspect. Before execution of: " + pjp.getSignature());
        Object result = pjp.proceed();
        LOGGER.info("LogAspect. After execution of: " + pjp.getSignature());
        return result;
    }

    @Around("execution(* operations.Operator.execute(..))")
    public Object operatorExecute(ProceedingJoinPoint pjp) throws Throwable {
        LOGGER.info("LogAspect. Before execution of: " + pjp.getSignature());
        Object result = pjp.proceed();
        LOGGER.info("LogAspect. After execution of: " + pjp.getSignature());
        return result;
    }

    @Around("execution(* parser.Parser.*(..))")
    public Object parserDetermine(ProceedingJoinPoint pjp) throws Throwable {
        LOGGER.info("LogAspect. Before execution of: " + pjp.getSignature());
        Object result = pjp.proceed();
        LOGGER.info("LogAspect. After execution of: " + pjp.getSignature());
        return result;
    }



}
