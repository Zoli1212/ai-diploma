<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div class="wrapper">
<div class="contact-form">
<h1>All job advertisement</h1>
<br/>

<c:forEach items="${send}" var="job">
<br/>
<center>
<p style="color: red;">${job.jobName}</p>
<p>${job.messageBody}</p><br/>
<p><i>${job.posterName}</i></p>
<strong>${job.contactPhone}</strong>
</center>


</c:forEach>

<div>
<div class="link">
<a href="<%=request.getContextPath()%>/RemoveJob">Admin</a>

</div>


</div>



</div>


</div>

</body>
</html>