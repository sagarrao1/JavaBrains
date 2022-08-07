package com.javabrains.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.javabrains.model.Rating;
import com.javabrains.model.UserRating;
import com.netflix.hystrix.contrib.javanica.annotation.*;

@Service
public class UserRatingInfo {
	
	@Autowired
	private RestTemplate restTemplate;	
	
//	 @HystrixCommand(fallbackMethod = "getFallbackUserRating",
//	            commandProperties = {
//	                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
//	                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
//	                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
//	                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000"),
//	            })
	@HystrixCommand(fallbackMethod = "getFallbackUserRating")
	public  UserRating getUserRating(@PathVariable("userId") String userId) {
		System.out.println("  usrRatingInfo  getUserRating ......");
		UserRating ratings = restTemplate.getForObject("http://ratings-data-service/ratingsdata/users/"+userId, UserRating.class);
		return ratings;
	}
	
	public UserRating getFallbackUserRating(@PathVariable("userId") String userId) {
		System.out.println("  usrRatingInfo getFallbackUserRating ......");
		UserRating userRating = new UserRating();
		userRating.setUserId(userId);
		userRating.setUserRating(Arrays.asList(new Rating("0", 0)));
		
		return userRating;
		
	}	

}
