package edu.sjsu.cmpe275.aop.aspect;

import edu.sjsu.cmpe275.aop.TweetStatsImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

/**
 * Created by svadhera on 10/1/16.
 */

@Aspect
public class StatsAspect {

    TweetStatsImpl tweetStats = new TweetStatsImpl();

    /**
     * Method tweetAfterReturning uses AfterReturning aspect to check if tweet was successful, and update the tweet stats accordingly
     *
     * @param joinPoint
     * @param result
     */
    @AfterReturning(
            pointcut = "execution(* edu.sjsu.cmpe275.aop.TweetServiceImpl.tweet(..))",
            returning = "result")
    public void tweetAfterReturning(JoinPoint joinPoint, Object result) {
        tweetStats.recordTweet(joinPoint.getArgs()[0].toString(), joinPoint.getArgs()[1].toString());
        System.out.println("Tweet " + joinPoint.getArgs()[0].toString() + " : " + joinPoint.getArgs()[1].toString() + " recorded");
    }

    /**
     * Method followAfter uses After aspect to check if follow completed and update the tweet stats accordingly
     *
     * @param joinPoint
     */
    @After("execution(* edu.sjsu.cmpe275.aop.TweetServiceImpl.follow(..))")
    public void followAfter(JoinPoint joinPoint) {
        tweetStats.recordFollow(joinPoint.getArgs()[0].toString(), joinPoint.getArgs()[1].toString());
        System.out.println(joinPoint.getArgs()[0].toString() + " following " + joinPoint.getArgs()[1].toString() + " recorded");
    }

}
