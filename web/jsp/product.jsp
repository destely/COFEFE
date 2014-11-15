<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--@elvariable id="cofefe" type="main.java.ru.eltech.cofefe.core.entity.Cofefe"--%>
<%--
  Created by IntelliJ IDEA.
  User: destely
  Date: 19.10.2014
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--@elvariable id="locale" type="java.util.Locale"--%>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="main.java.ru.eltech.cofefe.lang"/>

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
            <div class="row">
                <div class="tabs">
                    <div class="tab <c:if test="${initTab eq 'tab_short'}"> active </c:if>width-3" id="short" data="tab_short">
                        <div class="tab-name"><fmt:message key="DESCRIPTION"/></div>
                    </div>
                    <div class="tab <c:if test="${initTab eq 'tab_full'}"> active </c:if> width-3" id="full" data="tab_full">
                        <div class="tab-name"><fmt:message key="DETAILS"/></div>
                    </div>
                    <div class="tab <c:if test="${initTab eq 'tab_comments'}"> active </c:if> width-3" data="tab_comments">
                        <div class="tab-name"><fmt:message key="REVIEWS"/></div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="tab-content">
                    <div id="tab_short" class="tab-inner<c:if test="${initTab eq 'tab_short'}"> active </c:if>">
                        ${cofefe.shortDescription}
                    </div>
                    <div id="tab_full" class="tab-inner<c:if test="${initTab eq 'tab_full'}"> active </c:if>">
                        ${cofefe.description}
                    </div>
                    <div id="tab_comments" class="tab-inner<c:if test="${initTab eq 'tab_comments'}"> active </c:if>">
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row" style="margin-top: 10px;">
        <div class="width-12">
            <div class="btn btn-outline btn-normal" id="prod_id"><fmt:message key="ADD_TO_CART"/></div>
        </div>
    </div>
</div>

<script>

    function removeClass(el, cls) {//удаление класса из строки классов
        var oldClassName = el.className;
        var idx = oldClassName.indexOf(cls);//находим индекс класса в строке
        var newClassName = "";
        if (idx != -1) {//если найдено
            newClassName += oldClassName.substr(0, idx) + oldClassName.substr(idx + cls.length, oldClassName.length);
            el.className = newClassName;
        }
    }

    function generateCallback(id) {
        return function () {
            var ajaxRequest = new AjaxRequest({
                url: "/cofefe/app/cart/update?id=" + id + "&value=1",
                contentType: "application/json",
                dataType: "json"
            }, function (data) {
                if (data.success) {
                    alert("Продукт добавлен в корзину!");
                } else {
                    alert("Не удалось добавить продукт в корзину!");
                }
            }, function (error) {
                alert("Error: " + error);
            });
        };
    }
    document.getElementById("prod_id").onclick = generateCallback(${cofefe.id}); //берем id из бина

    var activeTab = document.getElementsByClassName("tab-content")[0].getElementsByClassName("active")[0];
    var activeButton = document.getElementsByClassName("tabs")[0].getElementsByClassName("active")[0];
    var tabButtons = document.getElementsByClassName("tab");//список всех кнопок
    for (var i = 0; i < tabButtons.length; i++) {//каждой кнопке задаем обработчик нажатия
        var button = tabButtons[i];
        button.onclick = function (btn) {
            return function () {
                var id = btn.attributes.data.value;
                var newTab = document.getElementById(id);
                newTab.className += " active";
                btn.className += " active";
                removeClass(activeTab, "active");
                removeClass(activeButton, "active");
                activeTab = newTab;
                activeButton = btn;
            };
        }(button);
    }

</script>
