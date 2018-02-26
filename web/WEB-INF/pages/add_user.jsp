<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加用户</title>
</head>
<body>
<%--methon和/result的提交方式一致 --%>
<%--<form action="/result" method="post">--%>
   <%--名字：<input type="text" name="name"><br>--%>
    <%--年龄：<input type="number" name="age"><br>--%>
          <%--<input type="submit" value="提交">--%>

<%--</form>--%>
<%--从modelmap中取值来填充表单--%>
<form:form action="result" method="post" modelAttribute="user">
    名字：<form:input path="name" /><br>
    年龄：<form:input path="age" /><br>
    <input type="submit" value="提交">
</form:form>

</body>
</html>