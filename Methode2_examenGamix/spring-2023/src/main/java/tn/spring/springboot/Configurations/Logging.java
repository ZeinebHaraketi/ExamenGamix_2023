package tn.spring.springboot.Configurations;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class Logging {

    @AfterReturning("execution(* tn.spring.springboot.Services.Implementation.*.MontantApayerParClient*(..))")
    public void apres(JoinPoint thisJoinPoint) {
        log.info("******* Montant facture calculée *************" /* + thisJoinPoint.getSignature().getName() */);
    }



}



// ***************   el méthode eli tebda b get ************* ////////////
/*

    @After("execution(* tn.spring.springboot.Services.Implementation.*.get*(..))")
    public void apres(JoinPoint thisJoinPoint) {
        log.info("******* aprés l'éxécution de la méthode qui commence par : get " + thisJoinPoint.getSignature().getName());
    }

 */

// ***************   durée de l'éxécution d'une méthode  ************* ////////////



                    /*

                    1) amel classe esmha PerformanceAspect





                                                import lombok.extern.slf4j.Slf4j;
                            import org.aspectj.lang.JoinPoint;
                            import org.aspectj.lang.ProceedingJoinPoint;
                            import org.aspectj.lang.annotation.Around;
                            import org.aspectj.lang.annotation.Aspect;
                            import org.aspectj.lang.annotation.Before;
                            import org.springframework.stereotype.Component;

                            import java.util.logging.Logger;

                            @Component
                            @Aspect
                            @Slf4j
                            public class PerformanceAspect {//calculer le temps

                                @Around("execution(* tn.spring.springboot.Services.Implementation.*.*(..))")
                                public Object profile(ProceedingJoinPoint pjp) throws Throwable {

                                    long start = System.currentTimeMillis();
                                    Object out = pjp.proceed();
                                    long elapsedTime = System.currentTimeMillis() - start;
                                    log.info("Method name : " + pjp.getSignature().getName()+ " type int only ");
                                    log.info("Method execution time: " + elapsedTime + " milliseconds.");
                                    return out;
                                }
                            }




                            2)

                                                @After("execution(* tn.spring.springboot.Controllers.*.*(..))")

                    public void logMethodEntry(JoinPoint joinPoint) {

                        String name = joinPoint.getSignature().getName();
                        //logger.de("In method " + name + " : ***********************");
                        logger.debug("In method " + name + " : ");

    }

                     */



/*

    @After("execution(* tn.spring.springboot.Services.Implementation.*.*(String))")
    public void apres(JoinPoint thisJoinPoint) {
        log.info("******* aprés l'éxécution de la méthode qui commence par : get " + thisJoinPoint.getSignature().getName());
    }

 */