package com.jakartafoodservice.web.jdbc;

public class Client 
{
	private int id;
	private String firstName;
	private String lastName;
	private String idNumber;
	private String email;
	private String address;
	private String appetizer;
	private String food;
	private String dessert;
	
	public Client(int id, String firstName, String lastName, String idNumber, String email, String address, String appetizer, String food, String dessert) 
	{
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = idNumber;
		this.email = email;
		this.address = address;
		this.appetizer = appetizer;
		this.food = food;
		this.dessert = dessert;
	}

	
	public Client(String firstName, String lastName, String idNumber, String email, String address, String appetizer, String food, String dessert)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = idNumber;
		this.email = email;
		this.address = address;
		this.appetizer = appetizer;
		this.food = food;
		this.dessert = dessert;
	}


	@Override
	public String toString() 
	{
		return "Client = [id = " + id + ", firstName = " + firstName + ", lastName = " + lastName + ", idNumber = " + idNumber + ", email = " + email
				+ ", address = " + address + ", appetizer = " + appetizer + ", food = " + food + ", dessert = " + dessert + "]";
	}


	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}


	public String getFirstName()
	{
		return firstName;
	}
	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}


	public String getLastName() 
	{
		return lastName;
	}
	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}


	public String getIdNumber() 
	{
		return idNumber;
	}
	public void setIdNumber(String idNumber) 
	{
		this.idNumber = idNumber;
	}


	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}


	public String getAddress() 
	{
		return address;
	}
	public void setAddress(String address) 
	{
		this.address = address;
	}


	public String getAppetizer() 
	{
		return appetizer;
	}
	public void setAppetizer(String appetizer)
	{
		this.appetizer = appetizer;
	}


	public String getFood() 
	{
		return food;
	}
	public void setFood(String food) 
	{
		this.food = food;
	}


	public String getDessert() 
	{
		return dessert;
	}
	public void setDessert(String dessert) 
	{
		this.dessert = dessert;
	}


	
	
	
	
	
	
	
	

}
