<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> welcome <%=session.getAttribute("activeUser") %> </title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<label>This is Profile page</label>
<label style="color:red">
Active user :: <%=session.getAttribute("activeUser") %><a href="${pageContext.request.contextPath }/logout"> ||Logout</a>
</label>
<hr>

<a href="${pageContext.request.contextPath }/student" >Student</a> &nbsp;
<a href="${pageContext.request.contextPath }/upload">upload</a> &nbsp;
<a href="${pageContext.request.contextPath }/rest">Rest </a> &nbsp;
<a href="${pageContext.request.contextPath }/new">tab4</a><br> &nbsp;
 




</body>
</html>