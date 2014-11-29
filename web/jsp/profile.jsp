<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <c:set var="link" scope="request"><c:url value="/app/product?id="/></c:set>
    <c:set var="imgLink" scope="request"><c:url value="/images"/></c:set>

    <span><fmt:message key="USER"/> ${user}</span>
    <br/>
    <span><fmt:message key="INITIAL_TAB"/> ${initTab}</span>

    <div style="margin-bottom: 40px;">
        <div style="margin-left: 30%">
            <h2>Список покупок:</h2>
        </div>
        <c:if test="${empty cofefe}">Список покупок пуст.</c:if>

        <c:forEach var="item" items="${cofefe}">
            <div style="margin-bottom: 20px;" class="width-5">
                <div class="row">
                    <div class="width-5">
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
                        <fmt:message key="QUANTITY"/> ${item.quantity}
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>