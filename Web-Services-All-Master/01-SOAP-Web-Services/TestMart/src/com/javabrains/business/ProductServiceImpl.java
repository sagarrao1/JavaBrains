
package com.javabrains.business;

import java.util.ArrayList;
import java.util.List;

import com.javabrains.model.Product;

public class ProductServiceImpl {
	List<String> bookList = new ArrayList<>();
	List<String> MusicList = new ArrayList<>();
	List<String> MovieList = new ArrayList<>();
	List<String> GameList = new ArrayList<>();

	public ProductServiceImpl() {
		bookList.add("JoyLand");
		bookList.add("How to think rich");
		bookList.add("Ramayana");

		MusicList.add("Atarinti daredi");
		MusicList.add("Abinandana");
		MusicList.add("Gang Leader");

		MovieList.add("black water");
		MovieList.add("Cast Away");
		MovieList.add("Shathamanam bhavathi");

		GameList.add("volleyball");
		GameList.add("cricket");
		GameList.add("tennis");
	}

	public List<String> getProductCatergories() {
		List<String> categories = new ArrayList<String>();
		categories.add("Books");
		categories.add("Music");
		categories.add("Movies");
		categories.add("Games");

		return categories;
	}

	public List<String> getProducts( String category){
		switch (category) {
		case "Books":
			return bookList;		
		case "Music":
			return MusicList;		
		case "Movies":
			System.out.println("in Movies ......");
			return MovieList;
		case "Games":
			return GameList;
		default:
			return null;		
		}
	}
	

	public boolean addProduct( String category, String product){
		
		switch (category) {
		case "Books" :
			 bookList.add(product);
			 break;
		case "Music" :
			MusicList.add(product);
			break;
		case "Movies" :		
			MovieList.add(product);
			System.out.println("In Movie added to list");
			break;
		case "Games" :
			 GameList.add(product);
			 break;
		default :
			return false;		
		}
		return true;
	}

	public List<Product> getProductsV2( String category){
		 List<Product> product_List= new ArrayList<>();
		 product_List.add(new Product("javaBrains","1234",45.56));
		 product_List.add(new Product("thinkRich","1235",95.96));
		 product_List.add(new Product("javaBrains","1236",215.83));
		return product_List;		
		}
	

}