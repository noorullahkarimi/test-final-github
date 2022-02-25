
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
<input name="debug" type="hidden" value="login">
<label>please inter your username</label><br>
<input name="username" ><br>
<label>please inter your password</label><br>
<input name="password" type="password"><br><br>
<input type="submit" value="press" >
</form>

</div>
</body>
</html>