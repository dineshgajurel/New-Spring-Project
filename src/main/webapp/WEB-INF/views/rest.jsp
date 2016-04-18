<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="${pageContext.request.contextPath }/resources/js/jquery.min.js"></script>
<!-- OR THIS
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
 -->
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

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

<h3>Rest Call Example:</h3>  
    <a href="${pageContext.request.contextPath }/stud">Go To Student</a> <br/> <br/>

    <input type="button" value="Get All Students: JSON Data" onclick="showJsonData()" /> <hr/>
    <p id="displayJSON"></p>

</body>
<script type="text/javascript">
    function showJsonData() {
        /*AJAX GET*/
        $.ajax({
            type : "GET",
            contentType : "application/json",
            url : "api/rest",
        }).then(function(data) {
            $('#displayJSON').html(JSON.stringify(data));
        });
    }
</script>

</html>