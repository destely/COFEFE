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

    <div>
        <%--@elvariable id="item" type="main.java.ru.eltech.cofefe.core.entity.BoughtItem"--%>
        <div class="width-7">
            <div style="margin-left: 30%">
                <h2>Список покупок:</h2>
            </div>
            <c:if test="${empty cofefe}">Список покупок пуст.</c:if>
            <c:forEach var="item" items="${cofefe}">
                <div class="width-6">
                    <div class="row">
                        <div class="width-5">
                            <div class="image" style="margin-top: 10px;">
                                <img src="${imgLink}/${item.cofefe.image}" style="width: 100%;"/>
                            </div>
                        </div>
                        <div class="width-5">
                            <div class="row">
                                <div class="width-12">
                                    <a href="${link}${item.cofefe.id}"><b>${item.cofefe.title}</b></a>
                                </div>
                            </div>
                            <div class="row">
                                <div class="width-12">
                                        ${item.cofefe.shortDescription}
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

        <div class="width-5">
            <h2>Комментарии:</h2>
            <textarea id="comment" class="form-input"></textarea>
        <span id="reviews_btn" style="margin-top: 20px;" class="btn btn-outline btn-normal width-5">
            <fmt:message key="REVIEWS"/>
        </span>

            <div class="width-8" style="margin-top: 20px; padding-left: 0px; padding-right: 0px;">
                <c:if test="${empty comments_list}">Комментарии отсутствуют.</c:if>

                <div id="cmnt_load">
                    <c:forEach var="itm" items="${comments_list}">
                        <div id="tam">
                        <div class="width-3" style="font-size: 10px;">
                                ${itm.date}
                        </div>
                        <div class="width-8" style="padding-left: 0px; padding-right: 0px; ">
                            <textarea class="form-input" style="height: 40px; font-size: 11px;"> ${itm.text}</textarea>
                        </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    var comment = document.getElementById("comment");
    var rvws_btn = document.getElementById("reviews_btn");
    var cmnt_load = document.getElementById("cmnt_load");

    var date = new Date();
    var dd = date.getDate();
    if(dd<10)dd = "0"+dd;
    var mm = date.getMonth()+1;
    if(mm<10) mm = "0"+mm;
    var yy = date.getFullYear();
    var h = date.getHours()+1;
    if(h<10) h = "0"+h;
    var m = date.getMinutes();
    if(m<10) m = "0"+m;
    var s = date.getSeconds();
    if(s<10) s = "0"+s;


    rvws_btn.onclick = setComment;

    function setComment() {
        var ajaxRequest = new AjaxRequest({
            url: "/cofefe/app/profile/setComment?text=" + comment.value,
            contentType: "application/json",
            dataType: "json"
        }, function (data) {
            if (data.success) {
               // data = data["result"];
               var tam = document.getElementById("tam");

                alert("Комментарий добавлен.");
                var clone = createFromTemplate(tam, comment.value);
                cmnt_load.appendChild(clone);


          } else {
                alert("Не удалось добавить комментарий.");
           }
        }, function (error) {
            alert("Error: " + error);
        });
    }

    function createFromTemplate(element, comment) {
        var clone = element.cloneNode(true);
      //  clone.style.display = "";
        clone.getElementsByClassName("width-3")[0].innerText = yy + "-"+ mm + "-" + dd + " " + h +":"+m+":"+s+".0";
        clone.getElementsByClassName("form-input")[0].innerText = comment;
        return clone;
    }
</script>