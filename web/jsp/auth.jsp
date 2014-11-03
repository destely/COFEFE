<%--
  Created by IntelliJ IDEA.
  User: destely
  Date: 03.11.2014
  Time: 18:45
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--@elvariable id="locale" type="java.util.Locale"--%>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="main.java.ru.eltech.cofefe.lang"/>

<div class="container" >
    <c:set var="actionUrl"><c:url value="/app/auth/"/></c:set>
    <form action="${actionUrl}" method="POST">
        <div class="form-control">
            <div class="row">
                <div class="width-3">
                    <label>Логин
                        <input name="login" class="form-input">
                    </label>
                </div>
            </div>
            <div class="row">
                <div class="width-3">
                    <label>Пароль
                        <input name="password" class="form-input">
                    </label>
                </div>
            </div>
        </div>
        <button type="submit" id="auth" class="btn btn-outline btn-normal"><fmt:message key="ENTER"/></button>
    </form>
</div>