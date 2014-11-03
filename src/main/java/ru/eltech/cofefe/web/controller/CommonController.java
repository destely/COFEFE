package main.java.ru.eltech.cofefe.web.controller;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by destely on 25.10.2014.
 */
public class CommonController implements BaseController {

    @Override
    public void handleGetRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String localeString = request.getParameter("locale");
        request.getSession().setAttribute("locale", localeString);
        Cookie cookie = new Cookie("locale", localeString);
        cookie.setPath("/");
        response.addCookie(cookie);
        response.sendRedirect("/cofefe/app");
    }

    @Override
    public void handlePostRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }

}
