package com.javabrains.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.javabrains.model.CatalogItem;
import com.javabrains.model.Movie;
import com.javabrains.model.Rating;
import com.javabrains.model.UserRating;
import com.javabrains.services.MovieInfo;
import com.javabrains.services.UserRatingInfo;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	UserRatingInfo userRatingInfo;
	
	@Autowired
	MovieInfo movieInfo;
	
//	@Autowired
//	private WebClient.Builder webClientBuilder;
	
	@RequestMapping("/{userId}")
//	@HystrixCommand(fallbackMethod = "getFallbackCatalog")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
		
		List<CatalogItem> catalogItems = new ArrayList<>();
//		RestTemplate restTemplate = new RestTemplate();
		
//		WebClient.Builder webClientBuilder=  WebClient.builder();
		
//		1. get all rated movie ids. as of now we are hard coding list of ratings		
//		List<Rating> ratings = Arrays.asList(
//				new Rating("123", 4),
//				new Rating("456", 5));
		
//		Rating[] ratings = restTemplate.getForObject("http://localhost:8083/ratingsdata/users/3", Rating[].class);
		
//		call ratings api to get (movieId and rating) Info for given userId. Instead of returning list in api, we are wrapping in as UserRating Object
//		which has List
//		UserRating ratings = restTemplate.getForObject("http://localhost:8083/ratingsdata/users/"+userId, UserRating.class);
		
		
//		Using Eurekha discovery service, we are removing hard coded uri (localhost:8083) to service name
		
				
		UserRating ratings = userRatingInfo.getUserRating(userId);	
		
		
//		2. for each movie id,call movie info service and get details
		 for (Rating rating : ratings.getUserRating()) {			 
//			 Movie[] movies = restTemplate.getForObject("http://localhost:8082/movies/"+rating.getMovieId(), Movie[].class);
		
			 
			 Movie movie = movieInfo.getCatalogItem(rating);
			 
			 
			 
//			 for (Movie  movie: movies) {
//				System.out.println(movie);
//			}
			 
			 catalogItems.add(new CatalogItem(movie.getName(), "", rating.getRating()));
		}		
		return catalogItems;
	}


	
//	public List<CatalogItem> getFallbackCatalog(@PathVariable("userId") String userId){
//		return Arrays.asList(new CatalogItem("No Movie", "HystrixCommand fallback command", 2));
//	}
	
	
}






//new way is usnig streams but not working 

//ratings.stream().map(rating -> {
//	new CatalogItem("CastAway", "Test", 4)
//}).collect(Collectors.toList());


//		3. put them all together

//return Collections.singletonList(
//		new CatalogItem("CastAway", "Test", 4)
//		);

//return Arrays.asList(new CatalogItem("CastAway", "Test", 4));


//Reactive way of doing using Webclint in asyncrhonus

/*
 * Movie[] movies = webClientBuilder.build() .get()
 * .uri("http://localhost:8082/movies/"+rating.getMovieId()) .retrieve()
 * .bodyToMono(Movie[].class) .block();
 */
