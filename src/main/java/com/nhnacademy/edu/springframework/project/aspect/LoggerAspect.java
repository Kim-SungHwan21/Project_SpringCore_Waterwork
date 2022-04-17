package com.nhnacademy.edu.springframework.project.aspect;

import com.nhnacademy.edu.springframework.project.BootStrap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class LoggerAspect {

    private static final Log log = LogFactory.getLog(BootStrap.class);

    @Around("execution(public * load(..))")
    public Object loadLogging(ProceedingJoinPoint pjp) throws Throwable {

        StopWatch stopWatch = new StopWatch();

        try {
            log.info("Method name: load");
            stopWatch.start();
            return pjp.proceed();
        } finally {
            stopWatch.stop();
            System.out.println(stopWatch.prettyPrint());
        }
    }

    @Around("execution(public * dataLoad(..))")
    public Object dataLoadLogging(ProceedingJoinPoint pjp) throws Throwable {

        StopWatch stopWatch = new StopWatch();

        try {
            log.info("Method name: dataLoad");
            stopWatch.start();
            return pjp.proceed();
        } finally {
            stopWatch.stop();
            System.out.println(stopWatch.prettyPrint());
        }
    }

    @Around("execution(public * calculateCharge(..))")
    public Object calculateChargeLogging(ProceedingJoinPoint pjp) throws Throwable {

        StopWatch stopWatch = new StopWatch();

        try {
            log.info("Method name: calculateCharge");
            stopWatch.start();
            return pjp.proceed();
        } finally {
            stopWatch.stop();
            System.out.println(stopWatch.prettyPrint());
        }
    }

    @Around("execution(public * report(..))")
    public Object reportLogging(ProceedingJoinPoint pjp) throws Throwable {

        StopWatch stopWatch = new StopWatch();

        try {
            log.info("Method name: report");
            stopWatch.start();
            return pjp.proceed();
        } finally {
            stopWatch.stop();
            System.out.println(stopWatch.prettyPrint());
        }
    }

}
