<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

No of Followers: <c:out value= "${fn:length(followerslist)}"  > </c:out>
<br>
List of Friends are: <select name = "box">
<Option value = "select">SELECT</Option>
<c:forEach items="${followerslist}" var="name">
<option>${name}</option>

</c:forEach>


</select>
The list box is empty excep
</body>
</html>