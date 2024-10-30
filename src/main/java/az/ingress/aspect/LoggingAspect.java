package az.ingress.aspect;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Pointcut("@annotation(Log) || @annotation(LogIgnore)")
    public void loggableMethods() {
    }

    @SneakyThrows
    @Around(value = "loggableMethods()")
    public Object logExecution(ProceedingJoinPoint jp){
        MethodSignature methodSignature = (MethodSignature)jp.getSignature();
        var method = methodSignature.getMethod();
        boolean isLogIgnore = method.isAnnotationPresent(LogIgnore.class);
        return isLogIgnore?jp.proceed():writeLog(jp);
    }

    private Object writeLog(ProceedingJoinPoint jp) throws Throwable {
        log.info("ActionLog.{}.start", jp.getSignature().getName());
        var response = jp.proceed();
        log.info("ActionLog.{}.end", jp.getSignature().getName());
        return response;
    }
}
