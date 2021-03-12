<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log in</title>
</head>
<body>
<form action="login" method="post">
  <label for="email">Email:</label><br>
  <input type="text" id="email" name="email" required><br>
  <label for="pwd">Password:</label><br>
  <input type="password" id="pwd" name="pwd" required><br>
  <input type="submit" id="submit" value="Submit">  
</form>
</body>
</html>