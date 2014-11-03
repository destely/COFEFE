package main.java.ru.eltech.cofefe.web.controller;

import main.java.ru.eltech.cofefe.core.entity.Cofefe;
import main.java.ru.eltech.cofefe.core.provider.CofefeProvider;
import main.java.ru.eltech.cofefe.core.provider.CofefeProviderStub;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by destely on 19.10.2014.
 */
public class ProductController implements BaseController {

    private CofefeProvider cofefeProvider = CofefeProviderStub.getInstance();

    @Override
    public void handlePostRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }

    @Override
    public void handleGetRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("content", "product.jsp");
        String idString = request.getParameter("id");
        Long id = Long.parseLong(idString);
        Cofefe cofefe = cofefeProvider.getById(id);
        request.setAttribute("cofefe", cofefe);
        request.getRequestDispatcher("/jsp/common.jsp").forward(request, response);
    }

}
