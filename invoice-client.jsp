<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Invoice Page</title>
    <link type = "text/css" rel="stylesheet" href="css/invoice-style.css">
</head>
<body>
    <div class="bill-container">
        <h1>Invoice Sheet</h1>
        
        <hr/>
        
        <c:forEach var = "tempClient" items = "${CLIENTS_ORDER}">
        	
        	<h2>Personal Information</h2>
        	
        	
        		<h4>First Name: ${tempClient.firstName}</h4>
        		
        		<h4>Last Name: ${tempClient.lastName}</h4>
        		
        		<h4>Phone Number: ${tempClient.idNumber}</h4>
        		
        		<h4>Email: ${tempClient.email}</h4>
        		
        		<h4>Address: ${tempClient.address}</h4>
        	
        	
        	<hr/>
        	
        	<h2>Orders</h2>
        	
      
        	<h4>Appetizer: ${tempClient.appetizer}</h4>
        	
        	<h4>Food: ${tempClient.food}</h4>
        	
        	<h4>Dessert: ${tempClient.dessert}</h4>
        	
        
        </c:forEach>
    </div>
</body>
</html>