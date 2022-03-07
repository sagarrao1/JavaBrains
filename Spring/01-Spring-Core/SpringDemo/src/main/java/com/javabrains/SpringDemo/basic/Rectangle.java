package com.javabrains.SpringDemo.basic;

public class Rectangle {

	private String type;
	private int height;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Rectangle() {

	}

	public Rectangle(String type) {
		this.type = type;
	}

	public Rectangle(int height) {
		this.height = height;
	}

	public Rectangle(String type, int height) {
		this.type = type;
		this.height = height;
	}

	public void draw() {
		System.out.println(getType() + " draw() method and height is " + getHeight());
	}

}
