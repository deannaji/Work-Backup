package com.uci.oit.test.myMockitoJ2SETest;

public class Client {
	private String name;
	private String location;
	
	public Client(String name, String loc){
		this.name = name;
		this.location = loc;
	}

	public String getName() {
		return name;
	}

	public String getLocation() {
		return location;
	}
	
	
}
