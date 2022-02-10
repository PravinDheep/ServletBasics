<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="ISO-8859-1">
<title>Printing Date</title>
</head>
<body>
<%@ page import="java.util.Date" %>
	<h3>Today's Date</h3>
	<%! Date today; %>
	<!--  expression -->
	 <% today = new Date(); %>
	<p>Current Date is : <% out.print(today); %></p>
	
	<h3>Include page</h3>
	<jsp:include page="./header.jsp"/>

	<h3>Include File</h3>
	<%@ include file="./header.jsp" %>
	
   </body>
</html>