<%--@elvariable id="item" type="main.java.ru.eltech.cofefe.core.entity.Cofefe"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: destely
  Date: 25.10.2014
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--@elvariable id="locale" type="java.util.Locale"--%>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="main.java.ru.eltech.cofefe.lang"/>


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
        <div class="width-12">
            <div cofefe-id="${item.id}" name="add_to_cart" class="btn btn-outline btn-normal"><fmt:message key="ADD_TO_CART"/></div>
        </div>
    </div>
</div>