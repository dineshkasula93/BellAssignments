<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Login</title>
</head>
<body>

 <div>
    Student Page
    <form:form action="${pageContext.request.contextPath}/student" method="post" modelAttribute="student">
       Name:<input type="text"  size="" maxlength="15" title="Please enter User Name" placeholder="Please enter User Name" name="Name"/><br><br>
       <div>
        <form:errors path="name" cssStyle="color:red"></form:errors>
        <form:errors path="fee" cssStyle="color:red"></form:errors>
        <form:errors path="year" cssStyle="color:red"></form:errors>
       </div>
       Course<select name="Course" id="singleCourse">`
     <option value ="java" >Java</option>
     <option value="android">Android</option>
     <option value="AJS">Angular Java Script</option>
     <option value="MVC">Spring MVC</option>
</select><br><br>
      Fee<input type="number" min="100"  title="Please enter the Fee" placeholder="Please enter the Fee" name="Fee" /><br><br>
      Year<input type="number" min="2017" title="Please enter the Year" placeholder="Please enter the Year" name="Year" /><br><br>
       <button type="submit"> SubmitXYZ </button>    
    </form:form>
 </div>

</body>
</html>
