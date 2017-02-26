<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<body>
<%
		String name = "";
		String course = "";
		String fee = "";
		String year = "";
		String curDate = "";

		name = request.getAttribute("NameRet").toString();
		course = request.getAttribute("CourseRet").toString();
		fee = request.getAttribute("FreRet").toString();
		year = request.getAttribute("YearRet").toString();
		curDate = request.getAttribute("CurDateRet").toString();
		out.println(name);
		out.println(course);
		out.println(fee);
		out.println(year);
		out.println(curDate);
	%>
	
 <div>
    ${message}
 </div>

</body>
</html>