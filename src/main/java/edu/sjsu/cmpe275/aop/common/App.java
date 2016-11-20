package edu.sjsu.cmpe275.aop.common;
import edu.sjsu.cmpe275.aop.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by svadhera on 10/1/16.
 */
public class App {
    public static void main(String[] args) throws Exception{
        ApplicationContext appContext = new ClassPathXmlApplicationContext(
                new String[] { "Spring.xml" });

        TweetService tweetService = (TweetService) appContext.getBean("tweetService");

        tweetService.tweet("Shubham", "jjjjjjjjjjjRetrying tweet due to network failure: 1st attemptRetrying tweet due to network failure: 1st attemptjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj");
        tweetService.tweet("Shubham", "Hey there !jkjk");
        tweetService.tweet("Banku", "Hey there !lk");
        tweetService.tweet("Akhil", "Hey there !lklklklk");
        tweetService.tweet("Peter", "Hey there !l");
        tweetService.tweet("kuttu", "Hey there !");

        tweetService.follow("Shubham","Ritika");
        tweetService.follow("Shubham","Banku");
        tweetService.follow("Likan","Meg");
        tweetService.follow("Peter","Meg");
        tweetService.follow("Bryan","Stewie");
        tweetService.follow("Bryan","Peter");

        TweetStats tweetStats = (TweetStats) appContext.getBean("tweetStats");

        System.out.println("Length of longest tweet: " + tweetStats.getLengthOfLongestTweet());
        System.out.println("Most active follower: " + tweetStats.getMostActiveFollower());
        System.out.println("Most productive user: " + tweetStats.getMostProductiveUser());

        tweetStats.resetStats();

        System.out.println("Length of longest tweet: " + tweetStats.getLengthOfLongestTweet());
        System.out.println("Most active follower: " + tweetStats.getMostActiveFollower());
        System.out.println("Most productive user: " + tweetStats.getMostProductiveUser());
    }
}
