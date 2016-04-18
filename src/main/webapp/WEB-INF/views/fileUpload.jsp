<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<label>This is Profile page</label>
<label style="color:red">
Active user <%=session.getAttribute("activeUser") %><a href="${pageContext.request.contextPath }/logout"> ||Logout</a>
</label>
<hr>

<a href="${pageContext.request.contextPath }/student" >Student</a> &nbsp;
<a href="${pageContext.request.contextPath }/upload">upload</a> &nbsp;
<a href="${pageContext.request.contextPath }/rest">Rest </a> &nbsp;
<a href="${pageContext.request.contextPath }/new">tab4</a><br> &nbsp;
 
<br>
<br>
This is file upload example.<br>

<form action="upload" method="POST" enctype="multipart/form-data" style="color:blue;border:1px solid">
File to upload:<input type="file" name ="file"/><br><br>
<input type="submit" value="upload" />


</form>

<label style="color:red">
${successMsg}
</label>
<br><br>
<C:if >
<a href="${pageContext.request.contextPath}/download?file=${downloadFilePath}"> Downlad File</a>
</C:if>
</body>
</html>