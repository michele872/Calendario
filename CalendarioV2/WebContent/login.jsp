<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	
	<form action="LoginServlet" method="post">
		<label>Email</label><br>
			<input type="text" name="email" placeholder="inserisci email" /><br>
			<input type="hidden" name="action" value="login" />
		<label>Password</label><br>
			<input type="password" name="password" placeholder="inserisci password" /><br><br>
			<input type="submit" name="submit" value="SUBMIT" />
			<input type="reset" name="clear" value="CLEAR" />
	</form>
</body>
</html>