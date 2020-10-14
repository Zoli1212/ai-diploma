<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/FormController" method="POST">

Full name: <input type="text" name="name"><br/>
Gender: <input type="radio" name="gender" value="female">Female
<input type="radio" name="gender" value="male"> Male<br/>
Languages known:
<input type="checkbox" name="language" value="english">English
<input type="checkbox" name="language" value="german">German
<input type="checkbox" name="language" value="russian">Russian<br/>
Country 
<select name="country">
<option value="france">France</option>
<option name="country" value="Russia">Russia</option>
<option name="country" value="India">India</option>
</select>
<br/>
<input type="submit" value="Submit">

</form>
</body>
</html>