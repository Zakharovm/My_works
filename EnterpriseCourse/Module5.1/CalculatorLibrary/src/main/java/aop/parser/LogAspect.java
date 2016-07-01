package aop.parser;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LogAspect {

    private Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);


    @Around("execution(* aop.parser.UtilOperation.*(..))")
    public Object utilPerformOperation(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("LogAspect. Before execution of: " + pjp.getSignature());
        Object result = pjp.proceed();
        System.out.println("LogAspect. After execution of: " + pjp.getSignature());
        return result;
    }

    @Around("execution(* aop.parser.Parser.*(..))")
    public void parserDetermine(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("LogAspect. Before execution of: " + pjp.getSignature());
        pjp.proceed();
        System.out.println("LogAspect. After execution of: " + pjp.getSignature());
    }

    @Around("execution(* aop.operations.Operator.execute(..))")
    public Object operatorExecute(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("LogAspect. Before execution of: " + pjp.getSignature());
        Object result = pjp.proceed();
        System.out.println("LogAspect. After execution of: " + pjp.getSignature());
        return result;
    }

}
