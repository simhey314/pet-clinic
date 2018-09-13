package com.heyden.spring.petclinic.entity;

public class Person extends BaseEntity {

	private String firstName;
	private String lastName;
	private String street;
	private String city;
	private String zip;
	private String telephone;

	public Person() {
	}

	public Person(final String firstName, final String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Person(final String firstName, final String lastName, final String street, final String city, final String zip, final String telephone) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.street = street;
		this.city = city;
		this.zip = zip;
		this.telephone = telephone;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(final String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(final String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(final String zip) {
		this.zip = zip;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(final String telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "Person{" +
				"firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", street='" + street + '\'' +
				", city='" + city + '\'' +
				", zip='" + zip + '\'' +
				", telephone='" + telephone + '\'' +
				"} " + super.toString();
	}
}
