<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--@elvariable id="locale" type="java.util.Locale"--%>
<%--
  Created by IntelliJ IDEA.
  User: destely
  Date: 03.11.2014
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="main.java.ru.eltech.cofefe.lang"/>

<h1>
  <b>
    <fmt:message key="ERROR"></fmt:message>
  </b>
</h1>