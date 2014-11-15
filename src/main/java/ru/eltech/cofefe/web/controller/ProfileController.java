package main.java.ru.eltech.cofefe.web.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Юлия on 15.11.2014.
 */
public class ProfileController implements BaseController {

    private String initTab;

    public ProfileController(final String initTab) {
        this.initTab = initTab;
    }

    @Override
    public void handleGetRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("content", "profile.jsp");
        request.setAttribute("initTab", initTab);
        request.getRequestDispatcher("/jsp/common.jsp").forward(request, response);
    }

    @Override
    public void handlePostRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }

}
