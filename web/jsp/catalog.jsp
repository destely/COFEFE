<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: destely
  Date: 19.10.2014
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--@elvariable id="locale" type="java.util.Locale"--%>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="main.java.ru.eltech.cofefe.lang"/>

<div class="container" style="margin-top: 50px;">

    <div class="row">
        <div class="width-12 form-element input-group" style="padding: 10px;">
            <input class="form-input" id="search">
            <span class="input-addon btn btn-normal btn-outline" id="search_btn"><i class="fa fa-search"></i></span>
        </div>
    </div>

    <%--@elvariable id="cofefe" type="main.java.ru.eltech.cofefe.core.entity.Cofefe"--%>
    <c:set var="link" scope="request"><c:url value="/app/product?id="/></c:set>
    <c:set var="imgLink" scope="request"><c:url value="/images"/></c:set>
    <div id="results">
        <c:forEach var="cofefe" items="${list}">
            <c:set var="item" scope="request" value="${cofefe}"/>
            <jsp:include page="item.jsp"/>
        </c:forEach>
    </div>

    <div style="margin-bottom: 20px; display: none;" class="width-5" id="template">
        <div class="row">
            <div class="width-7">
                <div class="image" style="">
                    <img class="template_image" src="${imgLink}/" style="width: 100%;"/>
                </div>
            </div>
            <div class="width-5">
                <div class="row">
                    <div class="width-12">
                        <a class="template_link" href="${link}"><b class="template_title"></b></a>
                    </div>
                </div>
                <div class="row">
                    <div class="width-12 template_description">

                    </div>
                </div>
            </div>
        </div>
        <div class="row" style="margin-top: 10px;">
            <div class="width-12">
                <div name="add_to_cart" class="btn btn-outline btn-normal"><fmt:message key="ADD_TO_CART"/></div>
            </div>
        </div>
    </div>

</div>

<script>

    var results = document.getElementById("results");
    var queryField = document.getElementById("search");
    queryField.onkeyup = function() {
        var val = queryField.value;
        setCookie("query", val, 1000000);
    };//выставляем куки по такому ключу с таким значением на время
    var cookieVal = getCookie("query");
    if (cookieVal) {
        queryField.value = cookieVal;
    }
    var searchBtn = document.getElementById("search_btn");
    searchBtn.onclick = function() {
        var ajaxRequest = new AjaxRequest({
            url: "/cofefe/app/catalog/search?query=" + queryField.value,
            contentType: "application/json",
            dataType: "json"
        }, function(data) {
            data = data["result"];
            var template = document.getElementById("template");
            results.innerHTML = "";
            for (var i = 0; i < data.length; i++) {
                var clone = createFromTemplate(template, data[i]);
                results.appendChild(clone);
            }
        }, function(error) {
            alert("Error: " + error);
        });
    };

    var addToCartButtons = document.getElementsByName("add_to_cart");
    for (var i = 0; i < addToCartButtons.length; i++) {
        var button = addToCartButtons[i];
        button.onclick = function(btn) {
            return function() {
                var ajaxRequest = new AjaxRequest({
                    url: "/cofefe/app/cart/update?id=" + btn.attributes["cofefe-id"].value + "&value=1",
                    contentType: "application/json",
                    dataType: "json"
                }, function(data) {
                    if (data.success) {
                        alert("Ура");
                    } else {
                        alert(":(");
                    }
                }, function(error) {
                    alert("Error: " + error);
                });
            };
        }(button);
    }


    function createFromTemplate(element, cofefe) {
        var clone = element.cloneNode(true);
        clone.style.display = "";
        clone.getElementsByClassName("template_image")[0].src += cofefe.image;
        clone.getElementsByClassName("template_link")[0].href += cofefe.id;
        clone.getElementsByClassName("template_title")[0].innerText += cofefe.title;
        clone.getElementsByClassName("template_description")[0].innerText = cofefe.description;
        clone.removeAttribute("id");
        return clone;
    }

    function setCookie(c_name, value, exdays) {
        var exdate = new Date();
        exdate.setDate(exdate.getDate() + exdays);
        var c_value = escape(value) + ((exdays == null) ? "" : "; expires=" + exdate.toUTCString());
        document.cookie = c_name + "=" + c_value;
    }

    function getCookie(c_name) {
        var i, x, y, ARRcookies = document.cookie.split(";");
        for (i = 0; i < ARRcookies.length; i++) {
            x = ARRcookies[i].substr(0, ARRcookies[i].indexOf("="));
            y = ARRcookies[i].substr(ARRcookies[i].indexOf("=") + 1);
            x = x.replace(/^\s+|\s+$/g, "");
            if (x == c_name) {
                return unescape(y);
            }
        }
    }

</script>