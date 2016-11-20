package edu.sjsu.cmpe275.aop;

import java.io.IOException;
import java.util.Random;

/**
 * Created by svadhera on 10/1/16.
 */

public class TweetServiceImpl implements TweetService {

    /**
     * Tweet method to simulate a tweet
     *
     * @param user    takes the name of user as String input
     * @param message the message as String input
     * @throws IllegalArgumentException if the message is more than 140 characters as measured by string length.
     * @throws IOException              if there is a network failure
     */
    public void tweet(String user, String message) throws IllegalArgumentException, IOException {
        if (message.length() > 140) throw new IllegalArgumentException("Message length more than 140");
        Random rand = new Random();
        int i = rand.nextInt(5) + 1;
        if (i == 1) throw new IOException("Network Error");
        else System.out.println("New Tweet-> " + user + " : " + message);
    }

    /**
     * Follow method to simulate a follow
     *
     * @param follower the user which attempts to follow another user
     * @param followee the user which is being followed by another user
     * @throws IOException if there is a network failure
     */
    public void follow(String follower, String followee) throws IOException {
        Random rand = new Random();
        int i = rand.nextInt(5) + 1;
        if (i == 1) {
            throw new IOException(follower + " following " + followee + " failed!");
        } else System.out.println("New Activity-> " + follower + " now follows " + followee);
    }
}
