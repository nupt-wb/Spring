package com.nupt.spring.bean.spel;

public class Car {
	
	private String brand;
	private double price;
	private double cycle;
	
	
	public double getCycle() {
		return cycle;
	}
	public void setCycle(double cycle) {
		this.cycle = cycle;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Car [brand=" + brand + ", price=" + price + ", cycle=" + cycle
				+ "]";
	}
	
	
}
