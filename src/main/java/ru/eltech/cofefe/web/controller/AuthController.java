package main.java.ru.eltech.cofefe.web.controller;

import main.java.ru.eltech.cofefe.core.entity.User;
import main.java.ru.eltech.cofefe.core.provider.UserProvider;
import main.java.ru.eltech.cofefe.core.provider.UserProviderStub;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by destely on 03.11.2014.
 */
public class AuthController implements BaseController {

    private UserProvider userProvider = UserProviderStub.getInstance();

    @Override
    public void handleGetRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String requestURI = request.getRequestURI();
        if (requestURI.contains("logout")) {
            request.getSession().invalidate();
            response.sendRedirect("/cofefe/app");
            return;
        }
        response.sendRedirect("/cofefe/app");
    }


    @Override
    public void handlePostRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }


}
