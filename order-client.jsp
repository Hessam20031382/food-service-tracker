<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order Page</title>
    <link type = "text/css" rel="stylesheet" href="css/order-style.css">
</head>
<body>
    <form action = "ClientControllerServlet" method = "get" class="food-form">
    	<input type = "hidden" name="command" value = "ORDER"/>
    	
    	<c:forEach var = "tempClient" items="${CLIENTS_LIST}">
    	
    		<input type="hidden" name = "clientId" value = "${tempClient.idNumber}"/>
    	
    		<h2>${tempClient.firstName} ${tempClient.lastName}</h2>
    		
    	</c:forEach>
    	
        <h2>Welcome To Jakarta Order Form</h2>
        
        <div class="order-line"></div>

	
		<label for="appetizer">Appetizer:</label>
		<input type="text" name="appetizer" placeholder="Choose an appetizer">      	
        
        <label for="food">Food:</label>
        
        <input type="text" name="food" placeholder="Choose a food">

        <label for="dessert">Dessert:</label>
       	<input type="text" name="dessert" placeholder="Choose a dessert">

		 <div class="line-order"></div>
		 
		 <h2>Personal Information</h2>
		
		<label for="email">Email:</label>
      	<input type="text" name="email" placeholder="Enter your email">

        <label for="address">Address:</label>
        <input type="text" name="address" placeholder="Enter your address">
        
        <div style="display:flex;justifu-content:center;align-items:center">
        	<button type="submit" >Order</button>
        </div>
    </form>
</body>
</html>