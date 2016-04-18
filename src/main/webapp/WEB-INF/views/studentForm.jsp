<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student</title>
</head>
<body>


	<label>This is Profile page</label>
	<label style="color: red"> Active user <%=session.getAttribute("activeUser")%><a
		href="${pageContext.request.contextPath }/logout"> ||Logout</a>
	</label>
	<hr>

	<a href="${pageContext.request.contextPath }/student">Student</a>
	&nbsp;
	<a href="${pageContext.request.contextPath }/upload">upload</a> &nbsp;
	<a href="${pageContext.request.contextPath }/rest">Rest </a> &nbsp;
	<a href="${pageContext.request.contextPath }/new">tab4</a>
	<br> &nbsp;



	<h1 style="color: blue">This is student</h1>

	<form:form method="POST" modelAttribute="student">
		<table>
			<tr>
				<td><form:label path="firstName">First Name:</form:label></td>
				<td><form:input path="firstName" /></td>
			</tr>
			<tr>
				<td><form:label path="lastName">Last Name:</form:label></td>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<td><form:label path="college">College:</form:label></td>
				<td><form:input path="college" /></td>
			</tr>
			<tr>
				<td><form:label path="rollno">Roll No:</form:label></td>
				<td><form:input path="rollno" /></td>
			</tr>
			<tr>
				<td><form:label path="subject">Subject:</form:label></td>
				<td><form:input path="subject" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="save" /></td>
			</tr>

		</table>
		<form:hidden path="id"></form:hidden>

	</form:form>

	<hr>
	<h3 style="color: red">Student Deatails:</h3>

	<table border="1" style="border-collapse: collapse">
		<thead>
			<tr>

				<th>&nbsp;</th>
				<th style="color: blue">Name</th>
				<th style="color: blue">Roll no</th>
				<th style="color: blue">Subject</th>
				<th style="color: blue">college</th>
				<th style="color: blue">Options</th>

			</tr>

		</thead>
		<tbody>

			<c:forEach var="row" items="${studentList}">
				<tr>
					<td></td>
					<td>${row.firstName},${row.lastName }</td>
					<td>${row.rollno}</td>
					<td>${row.subject}</td>
					<td>${row.college}</td>

					<td><input type="button" value="Edit" style="color: green"
						onclick="editStud(${row.id})" /> <input type="button"
						value="Delete" style="color: red" onclick="deleteStud(${row.id})" />
					</td>
				<tr>
			</c:forEach>

		</tbody>

	</table>

	<script type="text/javascript">
function editStud(id){
	location.href="${pageContext.request.contextPath}/student/"+id+"/edit";
}
function deleteStud(id){
	var r=confirm("Are u sure to delete?");
	if(r==true){
		location.href="${pageContext.request.contextPath}/student/"+id+"/delete";
	}
	
}

</script>










</body>
</html>