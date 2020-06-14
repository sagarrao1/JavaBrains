package com.javabrains.model;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Product")
@XmlType(propOrder = {"name","price","sku"})
public class Product {
	private String name;
	private String sku;
	private double price;
		
	public Product() {	
	}

	public Product(String name, String sku, double price) {
		this.name = name;
		this.sku = sku;
		this.price = price;
	}
	
	@XmlElement(name = "Pname")
	public String getName() {
		return name;
	}
	public String getSku() {
		return sku;
	}
	public double getPrice() {
		return price;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public void setPrice(double price) {
		this.price = price;
	}
		

}
