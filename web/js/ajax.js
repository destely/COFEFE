/**
 * Created by destely on 25.10.2014.
 */

function AjaxRequest(opts, successFunctionCallback, errorFunctionCallback) {
    var $this = this;
    var xmlhttp;
    try {//в виду отсутствия  XMLHttpRequest в старых браузерах
        xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
    } catch (e) {
        try {
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        } catch (E) {
            xmlhttp = false;
        }
    }
    if (!xmlhttp && typeof XMLHttpRequest != 'undefined') {
        xmlhttp = new XMLHttpRequest();
    }
    var url = opts.url;
    var contentType = opts.contentType;
    var data = opts.data;
    var dataType = opts.dataType;
    var method = opts.method;
    if (!method) {
        method = "GET";
    }

    if (data) {
        xmlhttp.setRequestHeader("Content-length", data.length);
    }

    xmlhttp.open(method.toUpperCase(), url, true);

    if (contentType) {
        xmlhttp.setRequestHeader('Content-Type', contentType)
    }

    xmlhttp.onload = function () {

        if (xmlhttp.status == 200) {
            var response = xmlhttp.response;
            if (dataType && dataType == "json") {
                try {
                    response = JSON.parse(response);
                } catch (e) {
                    errorFunctionCallback(e);
                }
            }

            successFunctionCallback(response);
        }
        else {
            errorFunctionCallback(Error(xmlhttp.statusText));
        }
    };

    xmlhttp.onerror = function () {
        errorFunctionCallback(Error("Network Error"));
    };

    xmlhttp.send(null);
}