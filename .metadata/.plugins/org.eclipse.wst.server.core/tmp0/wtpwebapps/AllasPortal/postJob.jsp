<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JobPortal</title>
</head>
<body>


	<div class="wrapper">
		<form class="contact-form" action="" method="post"
			id="postJobForm">
			<div>
				<h1>Insert your job information here</h1>

				<div class="input-fields">
					<input type="text" class="input" placeholder="Job Name"
						name="jobName"> <br/>
					<input type="text" class="input"
						placeholder="Poster Name" name="posterName"> <br/>
						
						<input
						type="password" class="input" placeholder="Password"
						name="password"> <br/>
						
						<input type="text" class="input"
						placeholder="Contact Phone" name="contactphone"><br/>

				</div>
				<div class="msg">
					<textarea placeholder="Message" name="messageBody"></textarea>

				</div>
				<div class="send">
					<input type="submit" class="btn" value="Submit" />

				</div>
			</div>
		</form>
	</div>

</body>
</html>