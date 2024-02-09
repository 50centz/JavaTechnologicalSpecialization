package com.example.demo.aspects;


import com.example.demo.model.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Component
@Aspect
public class LoggingAspect {


    @Around(value = "@annotation(TrackUserAction)")
    public Object logExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed =  joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        System.out.println(("LoggingAspect\nВызван метод: " + joinPoint.getSignature().getName() +
                "\nПередаваемые параметры: " + Arrays.toString(joinPoint.getArgs()) +
                "\nВремя обработки запроса: " + executionTime));

        return proceed;
    }
}
