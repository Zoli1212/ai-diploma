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
	  	<form class="contact-form" action="/JobPortal/postJob" method="POST" id="postJobForm">
	  		<div class="cim">
			<h1>Insert Job Informations Here</h1>	
		    </div>
		    <div class="input-fields">
		      <input type="text" class="input" placeholder="Job Name" name="jobname">
		      <input type="text" class="input" placeholder="Poster Name" name="postername">
		      <input type="password" class="input" placeholder="Password" name="password">
		      <input type="text" class="input" placeholder="Phone" name="contactphone">
		    </div>		    
		    <div class="msg">
		      <textarea placeholder="Message" name="messagebody"></textarea> 	
		    </div>
		    <div class="send">
		    	<input type="submit" class="btn" value="Submit" />	
		    </div>	    
	    </form>
	</div>
</body>
</html>