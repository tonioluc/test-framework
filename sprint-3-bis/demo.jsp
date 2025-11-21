<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Demo Page</title>
</head>
<body>
<h1>Demo view</h1>
<p>User: ${username}</p>
<h2>Items</h2>
<ul>
<%
    java.util.List items = (java.util.List) request.getAttribute("items");
    if (items != null) {
        for (Object it : items) {
%>
    <li><%= it %></li>
<%
        }
    } else {
%>
    <li>No items</li>
<%
    }
%>
</ul>
</body>
</html>
