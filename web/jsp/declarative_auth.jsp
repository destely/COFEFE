<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%--
  Created by IntelliJ IDEA.
  User: destely
  Date: 19.10.2014
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<html>
    <head>
        <title></title>
        <c:set var="cssLink"><c:url value="/css"/></c:set>
        <c:set var="jsLink"><c:url value="/js"/></c:set>
        <link rel="stylesheet" type="text/css" href="${cssLink}/main.css">
        <link rel="stylesheet" type="text/css" href="${cssLink}/font-awesome.css">
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <%--@elvariable id="locale" type="java.util.Locale"--%>
        <fmt:setLocale value="${locale}"/>
        <fmt:setBundle basename="main.java.ru.eltech.cofefe.lang"/>

        <div class="container">
            <c:set var="actionUrl"><c:url value="j_security_check"/></c:set>
            <form action="${actionUrl}" method="POST">
                <div class="form-control">
                    <div class="row">
                        <div class="width-3">
                            <label>Логин
                                <input name="j_username" class="form-input">
                            </label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="width-3">
                            <label>Пароль
                                <input name="j_password" class="form-input">
                            </label>
                        </div>
                    </div>
                </div>
                <button type="submit" id="auth" class="btn btn-outline btn-normal"><fmt:message key="ENTER"/></button>
            </form>
        </div>
    </body>
</html>