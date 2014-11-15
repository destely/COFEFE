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
        request.setAttribute("content", "auth.jsp");
        request.getRequestDispatcher("/jsp/common.jsp").forward(request, response);
    }

    @Override
    public void handlePostRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String referer = request.getParameter("referer"); //откуда пришёл пользователь
        User user = userProvider.getByLogin(login);
        if (user == null) {
            request.setAttribute("error", "Пользователь не найден");
            request.setAttribute("content", "error.jsp");
            request.getRequestDispatcher("/jsp/common.jsp").forward(request, response);
            return;
        }
        String userPassword = user.getPassword();
        if (userPassword.equals(password)) {
            request.getSession().setAttribute("user", user);
            if (referer == null || referer.isEmpty()) {
                response.sendRedirect("/cofefe/app/catalog");
            } else {
                response.sendRedirect(referer);
            }
        } else {
            request.setAttribute("error", "Неправильный пароль");
            request.setAttribute("content", "error.jsp");
            request.getRequestDispatcher("/jsp/common.jsp").forward(request, response);
        }
    }

}
