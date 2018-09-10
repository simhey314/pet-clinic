package com.heyden.spring.petclinic.entity;

public class PetType {

	private String name;

	public PetType() {
	}

	public PetType(final String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "PetType{" +
				"name='" + name + '\'' +
				'}';
	}
}
