package com.org.dao;

import java.util.ArrayList;
import java.util.List;


import org.springframework.social.twitter.api.Tweet;

import org.springframework.stereotype.Repository;

import com.org.entity.Tweetentity;
import com.org.service.TwitterService;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Repository
public class TwitterDAO {

	
	public JRDataSource getDataSource(String username,TwitterService service) {
		// TODO Auto-generated method stub
		
		//System.out.println("dao1"+username);
		List<Tweetentity> list1=new ArrayList<Tweetentity>();
		if(service==null)
		{
			System.out.println("service null");
		}
		List<Tweet> list=service.getUserTweet1(username);
	//	System.out.println("dao2 listsize" +list.size());
				for(Tweet t:list)
				{
					//System.out.println("dao2"+t.getText());
					Tweetentity tweetentity=new Tweetentity();
					tweetentity.setTweet(t.getText());
					tweetentity.setTime((t.getCreatedAt()).toString());
					list1.add(tweetentity);
				}

				
				
		JRDataSource ds = new JRBeanCollectionDataSource(list1); 
		return ds;
	}

}
