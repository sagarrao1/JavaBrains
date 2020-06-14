package com.javabrains;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.javabrains.business.ProductServiceImpl;
import com.javabrains.model.Product;

@WebService(endpointInterface = "com.javabrains.ProductCatalogInterface", serviceName = "TestMartCatalogService", portName = "TestMartCatalogPort")
public class ProductCatalog implements ProductCatalogInterface {
	
	ProductServiceImpl productService= new ProductServiceImpl();
		
	@Override	
	 public List<String> getProductCatergories(){
			return productService.getProductCatergories();
	} 

	@Override		
	 public List<String> getProducts(String category){
		   return productService.getProducts(category);
	}

	@Override	
	 public boolean addProduct(String category,String product){
		   return productService.addProduct(category, product);
	}

	@Override		
	 public List<Product> getProductsV2(String category){
		   return productService.getProductsV2(category);
	}

}
