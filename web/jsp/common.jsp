<%--
  Created by IntelliJ IDEA.
  User: destely
  Date: 19.10.2014
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
    <c:set var="cssLink"><c:url value="/css"/></c:set>
    <c:set var="jsLink"><c:url value="/js"/></c:set>
    <link rel="stylesheet" type="text/css" href="${cssLink}/main.css">
    <link rel="stylesheet" type="text/css" href="${cssLink}/font-awesome.css">
    <link rel="stylesheet" type="text/css" href="${cssLink}/map.css">
    <script src="${jsLink}/ajax.js">void(0);</script>

    <script scr="${jsLink}/mapScript.js"></script>


</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="${content}"/>
</body>
</html>
