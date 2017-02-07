package com.org.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.org.service.TwitterService;

@RestController
@RequestMapping("/resttwitter")
public class RestControllerTwitter {

	@Autowired
	private TwitterService twitterservice;
	
	@RequestMapping(method= RequestMethod.GET)
	public TwitterProfile getUserPost()
	{
		
		return twitterservice.getUserPost();
	}
	
	@RequestMapping(value="/post",method=RequestMethod.POST )
	public String postTweet()
	{
		return twitterservice.postTweet();
	}
	
	@RequestMapping(value="/{username}",method=RequestMethod.GET)
	public ArrayList<String> getUserTweet(@PathVariable String username)
	{
		
		return twitterservice.getUserTweet(username);
				
	}
}
