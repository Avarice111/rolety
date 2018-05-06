package com.rolety.domain;



public class Rolety
{
    private int id;
    private String name;
    private int size;
	private int price;
	
	public Rolety(){}

 public Rolety(int id, String name, int size, int price) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.price = price;
}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	} 
}