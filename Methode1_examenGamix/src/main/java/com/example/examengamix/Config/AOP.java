package com.example.examengamix.Config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class AOP {

    @After("execution(Float com.example.examengamix.Services.ExamServices.*(..))")
    public void logMethodEntry(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
       // log.info(name);
        log.info("montant Facture calculé"+name);

    }
}
