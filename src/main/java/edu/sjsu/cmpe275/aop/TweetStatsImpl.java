package edu.sjsu.cmpe275.aop;

import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by svadhera on 10/1/16.
 */

public class TweetStatsImpl implements TweetStats {

    private static int lengthOfLongestTweet = 0;
    private static TreeMap<String, HashSet<String>> followMap = new TreeMap<String, HashSet<String>>();
    private static TreeMap<String, Integer> tweetLengthMap = new TreeMap<String, Integer>();

    /**
     * method that resets the stats
     */
    public void resetStats() {
        lengthOfLongestTweet = 0;
        followMap = new TreeMap<String, HashSet<String>>();
        tweetLengthMap = new TreeMap<String, Integer>();
    }

    /**
     * Method to get the length longest tweet ever
     *
     * @return int value of length of longest tweet
     */
    public int getLengthOfLongestTweet() {
        return lengthOfLongestTweet;
    }

    /**
     * Method to return the most active follower in terms of total number of users followed
     *
     * @return String name of the user which attempted to follow most number of users
     */
    public String getMostActiveFollower() {
        String follower = null;
        int max = 0;
        for (Map.Entry<String, HashSet<String>> entry : followMap.entrySet()) {
            int numOfFollowers = entry.getValue().size();
            if (numOfFollowers > max) {
                max = numOfFollowers;
                follower = entry.getKey();
            }
        }
        return follower;
    }

    /**
     * Method to get the most productive user in terms of total tweet lengths
     *
     * @return String name of the user which tweeted the highest total length of tweets
     */
    public String getMostProductiveUser() {
        String user = null;
        int max = 0;
        for (Map.Entry<String, Integer> entry : tweetLengthMap.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                user = entry.getKey();
            }
        }
        return user;
    }

    /**
     * Method to record tweet statistics
     *
     * @param user    the user which sends the tweet
     * @param message the message sent in tweet
     */
    public void recordTweet(String user, String message) {
        int len = message.length();
        //update longest tweet
        if (len > lengthOfLongestTweet) lengthOfLongestTweet = len;

        //update tweetLengthMap
        if (tweetLengthMap.containsKey(user)) {
            int currLength = tweetLengthMap.get(user);
            currLength += len;
            tweetLengthMap.put(user, currLength);
        } else tweetLengthMap.put(user, len);

    }

    /**
     * Method to record follow statistics
     *
     * @param follower the user which follows other user
     * @param followee the user which is being followed by other user
     */
    public void recordFollow(String follower, String followee) {
        //update followMap
        HashSet<String> set;
        if (followMap.containsKey(follower)) set = followMap.get(follower);
        else set = new HashSet<String>();
        set.add(followee);
        followMap.put(follower, set);
    }

}
