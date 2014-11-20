<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--@elvariable id="locale" type="java.util.Locale"--%>
<%--
  Created by IntelliJ IDEA.
  User: Юлия
  Date: 15.11.2014
  Time: 20:26
  To change this template use File | Settings | File Templates.
--%>

<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="main.java.ru.eltech.cofefe.lang"/>

<div class="container">

    <span><fmt:message key="USER"/> ${user}</span>
    <br/>
    <span><fmt:message key="INITIAL_TAB"/> ${initTab}</span>

</div>