<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Remove Jobs</title>
</head>
<body>

<div class="wrapper">
<form class="contact-form" action="<%=request.getContextPath() %>/RemoveJob" method="post">

<h2>Remove allas by admin</h2>
<div class="input-fields">

<input type="text" class="input" placeholder ="JOB ID" name="id"><br/>

<input type="password" class="input" placeholder="PASSWORD" name="password"><br/>
<input type="submit" class="btn" value="Submit" />
<div>
<c:if test = "${error != null}">
<br/>
<h4 style="color: red;">Wrong post</h4>

</c:if>

</div>
 


</div>


</form>


</div>

</body>
</html>