<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="page-header">
    <div class="container">
        <c:set var="brandLink"><c:url value="/app/catalog"/></c:set>
        <a href="${brandLink}" class="brand movieshop-brand">
            Cofefe
        </a>


        <div class="controls">
            <a>${user}</a>
            <c:set var="ordering"><c:url value="/app/order"/></c:set>
            <c:if test="${not empty user}">
                <c:if test="${not empty cart}">
                    <a href="${ordering}" class="control">
                        <i class="fa fa-file-text"></i>
                    </a>
                </c:if>
            </c:if>
            <c:set var="cart"><c:url value="/app/cart"/></c:set>
            <a href="${cart}" class="control">
                <i class="fa fa-shopping-cart"></i>
            </a>
            <c:set var="profileLink"><c:url value="/app/profile"/></c:set>
            <c:if test="${not empty user}">
                <a href="${profileLink}" class="control">
                    <i class="fa fa-user"></i>
                </a>
            </c:if>
            <c:set var="logoutLink"><c:url value="/app/auth/logout"/></c:set>
            <c:set var="loginLink"><c:url value="/app/auth/protected"/></c:set>
            <c:choose>
                <c:when test="${user ne null}">
                    <a href="${logoutLink}" class="control">
                        <i class="fa fa-power-off"></i>
                    </a>
                </c:when>
                <c:otherwise>
                    <a href="${loginLink}" class="control">
                        <i class="fa fa-power-off"></i>
                    </a>
                </c:otherwise>
            </c:choose>
            <c:set var="catalogUrl"><c:url value=""/></c:set>
            <a href="${catalogUrl}" class="control">
                <i class="fa fa-book"></i>
            </a>
        </div>
    </div>
</div>

<c:set var="localeBaseLink"><c:url value="/app/common/setLocale?locale="/></c:set>
<div class="container">
    <div class="row controls">
        <div class="offset-8 width-3 sm-width-4">
            <div class="width-12 page-under-header">
                <a href="?locale=RU" class="control">
                    <i class="fa">RU</i>
                </a>
                <a href="?locale=EN" class="control">
                    <i class="fa">EN</i>
                </a>
                <a href="?locale=DE" class="control">
                    <i class="fa">DE</i>
                </a>
            </div>
        </div>
    </div>
</div>