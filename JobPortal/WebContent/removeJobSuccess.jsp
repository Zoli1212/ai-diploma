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
			<div class="success">
				<div>
					<h1>You have deleted post</h1>
				</div>
			</div>
			<div class="link">
				<a href=<%=request.getContextPath()%>">Back</a>
			</div>
		</div>
	</div>

</body>
</html>