<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<link rel="stylesheet" type="text/css" href="style.css">
	<title>JobPortal</title>
</head>

<body>
	<div class="wrapper">	
		<div class="contact-form">
			<div class="cim">
				<h1>Job Advertisements</h1>
				<br>
				<hr>
		    </div>
			<c:forEach items="${jobs}" var="job">			
				<div class="success">
					<h3 style="display: inline; font-style: oblique; font-style: 19px;">${job.jobName}</h3>
					<br>${job.messageBody}<br>
					<i style="font-size: 18px;">${job.posterName}</i>			
					<br><strong>${job.contactPhone}</strong>
					<br>
				</div>			
			</c:forEach>
			<div class="link">
				<a href="<%=request.getContextPath()%>/RemoveJob">Remove Post by Admin</a>
			</div>
		</div>	
	</div>
</body>
</html>