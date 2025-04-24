package com.jakartafoodservice.web.jdbc;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebServlet("/ClientControllerServlet")
public class ClientControllerServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	private ClientDbUtil clientDbUtil;
	
	@Resource(name = "jdbc/food_service_tracker")
	
	private DataSource dataSource;
	
	
	@Override
	public void init() throws ServletException 
	{
		super.init();
		try 
		{
			clientDbUtil = new ClientDbUtil(dataSource);
		} 
		catch (Exception exc) 
		{
			throw new ServletException(exc);
		}
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			String theCommand = request.getParameter("command");
			if (theCommand == null)
			{
				theCommand = "LOGIN";
			}
			switch (theCommand)
			{
			 case "LOGIN":
				 loginClient(request, response);
				 break;
				 
			 case "ORDER":
				 orderClient(request, response);
				 break;
			}
		}
		catch (Exception exc) 
		{
			throw new ServletException(exc);
		}		
	}


	private void orderClient(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		String idNumber = request.getParameter("clientId");
		String appetizer = request.getParameter("appetizer");
		String food = request.getParameter("food");
		String dessert = request.getParameter("dessert");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		
		Client theClient = new Client(null, null, idNumber, email, address, appetizer, food, dessert);
		
		clientDbUtil.orderClient(theClient);
		
		List<Client> clients = clientDbUtil.getClients(idNumber);
		
		request.setAttribute("CLIENTS_ORDER", clients);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/invoice-client.jsp");
		
		dispatcher.forward(request, response);	
	}


	private void loginClient(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String idNumber = request.getParameter("idNumber");
		
		Client theClient = new Client(firstName, lastName, idNumber, null, null, null, null, null);
		
		clientDbUtil.loginClient(theClient);
		
		List<Client> clients = clientDbUtil.getClients(idNumber);
		
		request.setAttribute("CLIENTS_LIST", clients);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/order-client.jsp");
		
		dispatcher.forward(request, response);
		
	}

}
