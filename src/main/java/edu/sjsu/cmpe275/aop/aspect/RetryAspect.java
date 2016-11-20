package edu.sjsu.cmpe275.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.io.IOException;

/**
 * Created by svadhera on 10/1/16.
 */

@Aspect
public class RetryAspect {

    /**
     * Method tweetAround uses Around aspect to check network failure and retry accordingly
     *
     * @param joinPoint
     * @throws Throwable
     */
    @Around("execution(* edu.sjsu.cmpe275.aop.TweetServiceImpl.tweet(..))")
    public void tweetAround(ProceedingJoinPoint joinPoint) throws Throwable {

        try {
            joinPoint.proceed();
        } catch (IOException e1) {
            System.out.println("Retrying tweet due to network failure: 1st attempt");
            try {
                joinPoint.proceed();
            } catch (IOException e2) {
                System.out.println("Retrying tweet due to network failure: 2nd attempt");
                try {
                    joinPoint.proceed();
                } catch (IOException e3) {
                    System.out.println("Tweet failed permanently");
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Tweet length more than 140 !");
        }
    }

    /**
     * Method followAround uses Around aspect to check network failure and retry accordingly
     *
     * @param joinPoint
     * @throws Throwable
     */
    @Around("execution(* edu.sjsu.cmpe275.aop.TweetServiceImpl.follow(..))")
    public void followAround(ProceedingJoinPoint joinPoint) throws Throwable {

        try {
            joinPoint.proceed();
        } catch (IOException e1) {
            System.out.println("Retrying follow due to network failure: 1st attempt");
            try {
                joinPoint.proceed();
            } catch (IOException e2) {
                System.out.println("Retrying follow due to network failure: 2nd attempt");
                try {
                    joinPoint.proceed();
                } catch (IOException e3) {
                    System.out.println("Follow failed permanently");
                }
            }
        }
    }
}
