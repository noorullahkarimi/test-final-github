
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login with hibernate and jsp</title>
<link href="index.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="content-all">
<form action="login" method="GET">
<input name="debug" type="hidden" value="register">
<label>please inter your username</label><br>
<input name="username" type="text"><br>
<label>please inter your password</label><br>
<input name="password" type="password"><br>

<label>please inter your zipcode</label><br>
<input name="zipcode" type="number"><br>
<label>please inter your address</label><br>
<input name="address" type="text"><br>

<label>please inter your email</label><br>
<input name="email"type="text"><br>
<label>please inter your phone number</label><br>
<input name="phonenumber" type="number"><br>
<input type="submit" value="register" >
</form>


<form action="login" method="get">
<input name="debug" type="hidden" value="switchlogin">
<input type="submit" value="you haven't an account?" >
</form>
</div>
</body>
</html>