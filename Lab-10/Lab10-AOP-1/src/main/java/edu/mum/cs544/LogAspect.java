package edu.mum.cs544;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class LogAspect {

    private static final Logger logger = LogManager.getLogger(LogAspect.class.getName());

    @After("execution(* edu.mum.cs544.EmailSender.sendEmail(String , String))")
    public void logAfter(JoinPoint joinpoint) {
        Object[] args = joinpoint.getArgs();
        String email = (String)args[0];
        String message = (String)args[1];
        String out = joinpoint.getTarget().toString();
        logger.warn("Method: " + joinpoint.getSignature().getName());
        logger.warn("Email-Address: " + email);
        logger.warn("Message: " + message);
        logger.warn("outgoing mail server: " + out);
    }

    @Around("execution(* edu.mum.cs544.CustomerDAO.save())")
    public Object invoke(ProceedingJoinPoint call ) throws Throwable {
        StopWatch   sw = new StopWatch();
        sw.start(call.getSignature().getName());
        Object retVal = call.proceed();
        sw.stop();
        long totaltime = sw.getLastTaskTimeMillis();

        logger.warn("CustomerDAO: " + totaltime);
        return retVal;
    }

}
