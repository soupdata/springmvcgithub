<%@ page import="zqr.com.springdao.entitys.InfoEntity" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>显示全部用户</title>
</head>
<body>

<ol>
   <% for (InfoEntity values :(List<InfoEntity>)request.getAttribute("infos")) { %>
    <li>名字:<% out.print(values.getName());%></li>
    <li>年龄:<% out.print(values.getAge());%></li>
    <%}%>


</ol>
<a href="adduser">添加用户</a>
</body>
</html>