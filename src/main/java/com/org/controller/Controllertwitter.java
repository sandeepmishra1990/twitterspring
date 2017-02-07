package com.org.controller;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.org.dao.TwitterDAO;
import com.org.service.TwitterService;

import net.sf.jasperreports.engine.JRDataSource;



@Controller
@RequestMapping("/twitterprofile")
public class Controllertwitter {
	
	@Autowired
	private TwitterService twitterservice;
	
	
	@RequestMapping(method= RequestMethod.GET)
	public ModelAndView getuserinfo()
	{
		ModelAndView modelAndView = new ModelAndView("info");
        modelAndView.addObject("profile",twitterservice.getUserPost());
        return modelAndView;
	}
	
	@RequestMapping(value="/usertweetpdf/{username}",method= RequestMethod.GET)
	public ModelAndView getpdfreport(@PathVariable String username)
	{
		Map<String,Object> parametermap=new HashMap<String,Object>();
		TwitterDAO dao=new TwitterDAO();
		JRDataSource datasource  = dao.getDataSource(username,twitterservice);
		parametermap.put("datasource",datasource);
		//System.out.println(twitterservice.getUserPost().getProfileImageUrl());
		parametermap.put("profileimage", twitterservice.getUserProfile(username));
		ModelAndView modelandview=new ModelAndView("pdfReport",parametermap);
		return modelandview;
	}
	
	@RequestMapping(value="/usertweetpdf1",method= RequestMethod.GET)
	public ModelAndView getreportpdf(@RequestParam(value="user") String username)
	{
		System.out.println(username);
		Map<String,Object> parametermap=new HashMap<String,Object>();
		TwitterDAO dao=new TwitterDAO();
		JRDataSource datasource  = dao.getDataSource(username,twitterservice);
		parametermap.put("datasource",datasource);
		//System.out.println(twitterservice.getUserPost().getProfileImageUrl());
		parametermap.put("profileimage", twitterservice.getUserProfile(username));
		ModelAndView modelandview=new ModelAndView("pdfReport",parametermap);
		return modelandview;
	}
	
	
	
	@RequestMapping(value="/followerslist",method= RequestMethod.GET)
	public ModelAndView getFollowersNFollowing(@RequestParam(value="user") String username ){
		
		
		ModelAndView modelandview=new ModelAndView("friends");
		modelandview.addObject("followerslist", twitterservice.getFollowersNFollowing(username));
		return modelandview;
	}
	
	
}
