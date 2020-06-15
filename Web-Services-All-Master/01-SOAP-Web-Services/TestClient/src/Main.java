import java.util.List;

import com.javabrains.TestMartCatalog;
import com.javabrains.TestMartCatalogService;
import com.testmart.Product;

public class Main {

	public static void main(String[] args) {
		// use web service as client
		// URL http://localhost:1234/productcatalog?wsdl
		
		TestMartCatalog testMartCatalog = new TestMartCatalogService().getTestMartCatalogPort();

		List<String> categories = testMartCatalog.fetchCategories();
		
		System.out.println("List if catagories:");
		for (String string : categories) {
			System.out.println(string);
		}
		
		System.out.println("----------------------");
		System.out.println("get products for Books category:");
		List<String> products = testMartCatalog.getProducts("Books");
		System.out.println(products.toString());
		
		System.out.println("----------------------");
		System.out.println("get productsv2 for Books category:");
		List<Product> productsv2 = testMartCatalog.getProductsV2("Books");
		for (Product product : productsv2) {
			System.out.println(product.getPname() +" : "+ product.getSku() + " : "+product.getPrice()  );
		}
		
		
	}

}
