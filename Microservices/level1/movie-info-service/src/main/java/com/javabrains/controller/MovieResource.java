package com.javabrains.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javabrains.model.Movie;

@RestController
@RequestMapping("/movies")
public class MovieResource {

	@RequestMapping("/{movieId}")
	public List<Movie> getMovie(@PathVariable("movieId") String movieId){
		
		return Collections.singletonList(
				new Movie(movieId, "Test Movie name")
				);
		
//		return Arrays.asList(new CatalogItem("CastAway", "Test", 4));
	}
}
