<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Login Page</title>
  <link type = "text/css" rel="stylesheet" href="css/login-style.css" />
</head>
<body>
  <div class="login-wrapper">
    <!-- المان‌های پس‌زمینه تزئینی -->
    <div class="background">
      <div class="red-circle"></div>
      <img class="silhouette" src="silhouette.png" alt="Silhouette" />
      <div class="leaf-left"></div>
      <div class="leaf-right"></div>
    </div>
    <!-- بخش فرم لاگین -->
    <div class="login-box">
      <h1>LOGIN</h1>
      <form action= "ClientControllerServlet" method="get">
      	<input type = "hidden" name = "command" value = "LOGIN"/>
        <div class="input-group">
          <label>First Name</label>
          <input type="text" name="firstName" placeholder="Enter your First Name" />
        </div>
       <div class="input-group">
          <label>Last Name</label>
          <input type="text" name="lastName" placeholder="Enter your Last Name" />
     	</div>
     	<div class="input-group">
          <label>Phone Number</label>
          <input type="text" name="idNumber" placeholder="Enter your Phone Number" />
     	</div>
     	<button type="submit" class="btn-continue">CONTINUE</button>
      </form>   		
    </div>
  </div>
</body>
</html>