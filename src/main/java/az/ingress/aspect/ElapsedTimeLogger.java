package az.ingress.aspect;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ElapsedTimeLogger {
    @Pointcut(value = "execution(* az.ingress.service.concrete.EmployeeServiceHandler.*(..))")
    public void elapsedTimePointCut(){
    }

    @SneakyThrows
    @Around(value = "elapsedTimePointCut()")
    public Object elapsedTimeLogger(ProceedingJoinPoint jp){
        var startDate = System.currentTimeMillis();
        var response = jp.proceed();
        var endDate = System.currentTimeMillis();
        log.info("Elapsed time:{}", endDate-startDate);
        return response;
    }
}
