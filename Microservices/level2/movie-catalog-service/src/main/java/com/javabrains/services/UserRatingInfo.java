package com.javabrains.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.javabrains.model.Rating;
import com.javabrains.model.UserRating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class UserRatingInfo {
	
	@Autowired
	private RestTemplate restTemplate;	
	
	@HystrixCommand(fallbackMethod = "getFallbackUserRating")
	public  UserRating getUserRating(String userId) {
		System.out.println("  usrRatingInfo  getUserRating ......");
		UserRating ratings = restTemplate.getForObject("http://ratings-data-service/ratingsdata/users/"+userId, UserRating.class);
		return ratings;
	}
	
	public UserRating getFallbackUserRating(String userId) {
		System.out.println("  usrRatingInfo getFallbackUserRating ......");
		UserRating userRating = new UserRating();
		userRating.setUserRating(Arrays.asList(new Rating("0", 0)));
		
		return userRating;
		
	}	

}
