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
	  	<form class="contact-form" action="<%=request.getContextPath() %>/RemoveJob" method="POST">
	  		<div class="cim">
					<h1>Remove Post by Admin</h1>
					<br/>
		    </div>
		    <div class="input-fields">
		      <input type="text" class="input" placeholder="Job ID" name="id">
		      <input type="password" class="input" placeholder="Password" name="password">
		    </div>
		    <div class="send">
		    	<input type="submit" class="btn" value="Submit" />	
		    </div>
		    <div class="cim">
		    	<c:if test = "${error != null}">
		    		<br>
					<h4 style="color: yellow">Something Wrong</h4>
					<br/>
				</c:if>
		    </div>
	    </form>
	</div>
</body>
</html>