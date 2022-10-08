<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="SendEmail" action="post">
To <input type="text" name="to" value="${email}"/>
Subject<input type="text" name="sub"/>
Compose:
<textarea  name="emailBody" rows="40" cols="50">
</textarea>
<input type="submit" value="Send"/>
</form>
</body>
</html>