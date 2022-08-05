package com.javabrains.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.javabrains.model.Movie;
import com.javabrains.model.MovieSummary;

@RestController
@RequestMapping("/movies")
public class MovieResource {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${api.key}")
	private String API_KEY;

	@RequestMapping("/{movieId}")
	public Movie getMovie(@PathVariable("movieId") String movieId){
	
//		hard coded movie
//		return new Movie(movieId, "Test Movie name");
		
//		Calling external api "themoviedb"
		MovieSummary movieSummary = restTemplate.getForObject("https://api.themoviedb.org/3/movie/"+ movieId +"?api_key="+API_KEY, MovieSummary.class);				
						
		return new Movie(movieSummary.getId(),movieSummary.getTitle(),movieSummary.getOverview() );
	}
}
