package com.org.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.social.twitter.api.CursoredList;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.TweetData;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.stereotype.Service;


@Service
public class TwitterService {

	private final String consumerKey = "T1H0B7KFAU2bqTdgjG8x1FXZZ"; // The application's consumer key
	private final String consumerSecret = "xmOzfLALWyRCbtbEvzYdqamEOUprpCEnyW48Tdf8JgQEAGM963"; // The application's consumer secret
	private final String accessToken = "159379818-hhzJ1CC6PmrKA0jjJc0iORjZ40SXRF0OS0QXx5BN"; // The access token granted after OAuth authorization
	private final String accessTokenSecret = "2vfDgtHl9eigVUILMJ9cpzg5nnv2hjjSUZUzgvLGUBvgG"; // The access token secret granted after OAuth authorization
	private Twitter twitter=null;
	
	public TwitterService()
	{
	 twitter= new TwitterTemplate(consumerKey, consumerSecret, accessToken, accessTokenSecret);
	}
	
	public TwitterProfile getUserPost()
	{

		TwitterProfile profile=twitter.userOperations().getUserProfile();
		return profile;
	}
	
	
	public String postTweet()
	{
				
		twitter.timelineOperations().updateStatus(new TweetData("Spring-Social Twitter Testing....!").atLocation(-0.126f, 51.502f));
		return "success";
		
	}
	
	public ArrayList<String> getUserTweet(String username)
	{

		List<Tweet>  tweets=twitter.timelineOperations().getUserTimeline(username);
		ArrayList<String> alist=new ArrayList<String>();
		for(Tweet tweet:tweets)
		{
			alist.add(tweet.getText());
		}
		return alist;
	
		
	}
	
	public List<Tweet> getUserTweet1(String username)
	{
System.out.println("ssssss");
if(twitter==null)
{
	System.out.println("twitter null");
}
System.out.println("twitter not null");
		List<Tweet>  tweets=twitter.timelineOperations().getUserTimeline(username);
		/*for(Tweet t:tweets)
		{
			System.out.println(t.getText());
		}
		System.out.println("tttt");*/
		return tweets;
	
		
	}

	public String getUserProfile(String username) {
		// TODO Auto-generated method stub
		TwitterProfile twitterprofile = twitter.userOperations().getUserProfile(username);
		String profileimage=twitterprofile.getProfileImageUrl();
		return profileimage;
	}
	
	public ArrayList<String> getFollowersNFollowing(String username){
		
		CursoredList<TwitterProfile> list=twitter.friendOperations().getFollowers(username);
		ArrayList<String> al=new ArrayList<String>();
		for(TwitterProfile profile:list)
		{
			al.add((profile.getName()+"++++Username++++"+profile.getScreenName()));
		}
		
		return al;
		
	}
	
}
