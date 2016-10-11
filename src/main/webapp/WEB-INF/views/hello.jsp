<%--
  Created by IntelliJ IDEA.
  User: Kiranmai
  Date: 10/6/16
  Time: 7:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form modelAttribute="helloForm" method="post">

    <form:input path="prefix"/>
    <br/>
    <form:input path="person.first"/>

    <input type="submit" value="Save"/>

</form:form>


</body>
</html>
