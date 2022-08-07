package com.javabrains.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javabrains.model.Rating;
import com.javabrains.model.UserRating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsDataResource {

	@RequestMapping("/{movieId}")
	public List<Rating> getRating(@PathVariable("movieId") String movieId){
		
		return Collections.singletonList(
				new Rating(movieId,  4)
				);
		
//		return Arrays.asList(new CatalogItem("CastAway", "Test", 4));
	}
	
	@RequestMapping("users/{userId}")
	public UserRating getRatingsOfUser(@PathVariable("userId") String userId){
		
		List<Rating> ratings = new ArrayList<>();
		
		ratings= Arrays.asList(
				new Rating("123",  4),
				new Rating("124",  3)
				);
		
//		if you want to return Object instead of list , you create new Object with list and return that
		
		UserRating userRating=  new UserRating();
		userRating.setUserId(userId);
		userRating.setUserRating(ratings);
		return userRating;
		
				
	}
}
