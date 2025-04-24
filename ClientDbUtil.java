package com.jakartafoodservice.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class ClientDbUtil 
{
	private DataSource dataSource;

	public ClientDbUtil(DataSource dataSource) 
	{
		this.dataSource = dataSource;
	}
	
	
	public List<Client> getClients(String find) throws Exception
	{
		List<Client> clients = new ArrayList<Client>();
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try 
		{
			connection = dataSource.getConnection();
			
			String sql = "select * from client where id_number = " + find;
			
			statement = connection.createStatement();
			
			resultSet = statement.executeQuery(sql);
			
			while (resultSet.next())
			{
				int id = resultSet.getInt("id");
				String firstName = resultSet.getString("first_name");
				String lastName = resultSet.getString("last_name");
				String idNumber = resultSet.getString("id_number");
				String email = resultSet.getString("email");
				String address = resultSet.getString("address");
				String appetizer= resultSet.getString("appetizer");
				String food = resultSet.getString("food");
				String dessert = resultSet.getString("dessert");
				
				Client client = new Client(id, firstName, lastName, idNumber, email, address, appetizer, food, dessert);
				
				clients.add(client);
			}
			return clients;
		} 
		finally 
		{
			Close(connection, statement, resultSet, null);
		}
	}


	private void Close(Connection connection, Statement statement, ResultSet resultSet, PreparedStatement preparedStatement) 
	{
		try
		{
			if (connection != null)
			{
				connection.close();
			}
			if (statement != null)
			{
				statement.close();
			}
			if (resultSet != null)
			{
				resultSet.close();
			}
			if (preparedStatement != null)
			{
				preparedStatement.close();
			}
		}
		catch (Exception exc)
		{
			exc.printStackTrace();
		}
	}


	public void loginClient(Client theClient) throws Exception
	{
		Connection connection = null;
		
		Statement statement = null; 
		
		PreparedStatement preparedStatement = null;
		
		ResultSet resultSet = null;
		
		try 
		{			
			connection = dataSource.getConnection();
			
			String sql = "select * from client where id_number = " + theClient.getIdNumber();
			
			statement = connection.createStatement();
			
			resultSet = statement.executeQuery(sql);
			
			String clientId = null;
			
			while(resultSet.next())
			{
				clientId = resultSet.getString("id_number");
			}
			
			if (clientId == null)
			{
				String sql1 = "insert into client " + "(first_name, last_name, id_number)" + "values (?, ?, ?)";
				
				preparedStatement = connection.prepareStatement(sql1);
			
				preparedStatement.setString(1, theClient.getFirstName());
				preparedStatement.setString(2, theClient.getLastName());
				preparedStatement.setString(3, theClient.getIdNumber());
			
				preparedStatement.execute();
			}		
		}
		finally 
		{
			Close(connection, statement, resultSet, preparedStatement);
		}
	}


	public void orderClient(Client theClient) throws Exception
	{
		Connection connection = null;
		
		PreparedStatement preparedStatement = null;
		
		try 
		{
			connection = dataSource.getConnection();
			
			String sql = "update client set email=?, address=?, appetizer=?, food=?, dessert=? where id_number=?";
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, theClient.getEmail());
			preparedStatement.setString(2, theClient.getAddress());
			preparedStatement.setString(3, theClient.getAppetizer());
			preparedStatement.setString(4, theClient.getFood());
			preparedStatement.setString(5, theClient.getDessert());
			preparedStatement.setString(6, theClient.getIdNumber());
			
			preparedStatement.execute();
		} 
		finally 
		{
			Close(connection, null, null, preparedStatement);
		}
		
	}
	
	

}
