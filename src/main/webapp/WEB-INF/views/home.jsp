<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<script type="text/javascript" src="<%= request.getContextPath() %>/resources/js/jquery-3.0.0.min.js"></script>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<img src= "<%= request.getContextPath() %>/resources/img/1.jpg" />
<%= request.getContextPath() %>
</body>
</html>
