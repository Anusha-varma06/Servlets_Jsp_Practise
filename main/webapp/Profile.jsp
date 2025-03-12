<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Profile page</h1>
   <%
   String name=(String)session.getAttribute("name");
   String password=(String)session.getAttribute("password");
   String email=(String)session.getAttribute("email");
   String mobile=(String)session.getAttribute("mobile");
   String gender=(String)session.getAttribute("gender");
   %>
   name:<%=name %>
   password:<%=password %>
   email:<%=email %>
   mobile:<%=mobile %>
   gender:<%=gender %>
   <a href="Logout">logout</a>
</body>
</html>