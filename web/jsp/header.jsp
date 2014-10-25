
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="page-header">
    <div class="container">
        <c:set var="brandLink"><c:url value=""/></c:set>
        <a href="${brandLink}" class="brand movieshop-brand">
            Cofefe
        </a>
        <div class="controls">
            <c:set var="cart"><c:url value=""/></c:set>
            <a href="${cart}" class="control">
                <i class="fa fa-shopping-cart"></i>
            </a>
            <c:set var="profileLink"><c:url value=""/></c:set>
            <a href="${profileLink}" class="control">
                <i class="fa fa-user"></i>
            </a>
            <c:set var="logoutLink"><c:url value=""/></c:set>
            <a href="${logoutLink}" class="control">
                <i class="fa fa-power-off"></i>
            </a>
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
                <c:set var="profileLink"><c:url value=""/></c:set>
                <a href="${localeBaseLink}RU" class="control">
                    <i class="fa">RU</i>
                </a>
                <c:set var="profileLink"><c:url value=""/></c:set>
                <a href="${localeBaseLink}EN" class="control">
                    <i class="fa">EN</i>
                </a>
                <c:set var="profileLink"><c:url value=""/></c:set>
                <a href="${localeBaseLink}DE" class="control">
                    <i class="fa">DE</i>
                </a>
            </div>
        </div>
    </div>
</div>