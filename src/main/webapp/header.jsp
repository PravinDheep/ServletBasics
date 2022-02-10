<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="ISO-8859-1">
<title>Printing Date</title>
</head>

<%@ page import="java.util.Date" %>
<body>
<pre>
<h1>Test Application</h1>
<% out.println(new Date()); %>
<% 
   int i= 10;
   int j= 30;
   out.println(i+j);
%>
</pre>
</body>
</html>