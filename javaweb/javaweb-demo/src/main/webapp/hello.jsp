<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello Specific Person</title>
</head>
<body>
<h1><%= "Hello World!" %></h1>
<%
  var queryString = request.getQueryString();
  var message = queryString.substring(queryString.indexOf('=') + 1);

  response.setContentType("text/html");
%>
<br/>
<h1>Hello, <%= message %>!!!!!!!!!</h1>
</body>
</html>