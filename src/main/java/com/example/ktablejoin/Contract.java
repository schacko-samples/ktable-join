package com.example.ktablejoin;

public class Contract {

	private int id;
	private String name;

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

	@Override
	public String toString() {
		return "Contract{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
