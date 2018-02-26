<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    名字：${name}<br>
    年龄：${age}
</div>
<%
  response.sendRedirect("infos");
%>
</body>
</html>