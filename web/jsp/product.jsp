<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="cofefe" type="main.java.ru.eltech.cofefe.core.entity.Cofefe"--%>
<%--
  Created by IntelliJ IDEA.
  User: destely
  Date: 19.10.2014
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div class="container">

    <div class="row">
        <div class="title">
        <h2>
            <b>${cofefe.title}</b>
        </h2>
        </div>
    </div>

    <div class="row">
        <div class="width-6">
            <div class="image">
                <c:set var="imgLink"><c:url value="/images"/></c:set>
                <img src="${imgLink}/${cofefe.image}"/>
            </div>
        </div>
        <div class="width-6">
            <div class="description">${cofefe.description}</div>
        </div>
    </div>

</div>
