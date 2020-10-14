<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>


<form action="<%=request.getContextPath() %>/FormController" method="POST">

Full Name : <input type="text" name="name"><br/>
Gender: <input type="radio" name="gender" value="male">Male
		<input type="radio" name="gender" value="female">Female<br/>
Lanquage: 
<input type="checkbox" name="lanquage" value="english">English
<input type="checkbox" name="lanquage" value="russian">Russian
<input type="checkbox" name="lanquage" value="german">German<br/>
Country
<select name="country">
<option value="france">France</option>
<option value="german">German</option>
<option value="netherland">Netherland</option>

<input type="submit" value="Submit">
</select>






</form>


</body>
</html>