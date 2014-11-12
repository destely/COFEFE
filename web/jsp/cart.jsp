<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: destely
  Date: 03.11.2014
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--@elvariable id="locale" type="java.util.Locale"--%>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="main.java.ru.eltech.cofefe.lang"/>


<div class="container" style="margin-top: 50px;">
    <div id="cart">
        <%--@elvariable id="item" type="main.java.ru.eltech.cofefe.core.entity.CartItem"--%>
        <c:set var="link" scope="request"><c:url value="/app/product?id="/></c:set>
        <c:set var="imgLink" scope="request"><c:url value="/images"/></c:set>
        <c:set var="removeLink" scope="request"><c:url value="/app/cart/remove?id="/></c:set>
        <c:forEach var="item" items="${cart}">
            <div style="margin-bottom: 20px;" class="width-5">
                <div class="row">
                    <div class="width-7">
                        <div class="image" style="">
                            <img src="${imgLink}/${item.image}" style="width: 100%;"/>
                        </div>
                    </div>
                    <div class="width-5">
                        <div class="row">
                            <div class="width-12">
                                <a href="${link}${item.id}"><b>${item.title}</b></a>
                            </div>
                        </div>
                        <div class="row">
                            <div class="width-12">
                                    ${item.shortDescription}
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row" style="margin-top: 10px;">
                    <div class="width-6">
                        <fmt:message key="NOW_IN_CART"/> ${item.quantity}
                    </div>
                    <div class="width-6">
                        <a href="${removeLink}${item.id}" class="btn btn-outline btn-normal"><fmt:message key="REMOVE_FROM_CART"/></a>
                    </div>
                </div>
            </div>
        </c:forEach>

            <a href="#" onclick="alert('Для совершения заказа, авторизуйтесь.') "class="btn btn-outline btn-normal"><fmt:message key="ORDER"/></a>
            <%--<c:set var="orderLink"><c:url value="/app/cart/order"/></c:set>--%>
        <%--<a href="${orderLink}" class="btn btn-outline btn-normal"><fmt:message key="ORDER"/></a>--%>
    </div>
</div>

