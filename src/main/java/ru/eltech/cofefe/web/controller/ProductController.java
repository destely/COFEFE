package main.java.ru.eltech.cofefe.web.controller;

import main.java.ru.eltech.cofefe.core.entity.Cofefe;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by destely on 19.10.2014.
 */
public class ProductController extends BaseController {

    @Override
    public void handlePostRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }

    @Override
    public void handleGetRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("content", "product.jsp");
        Cofefe cofefe = new Cofefe();
        cofefe.setDescription("Описание продукта");
        cofefe.setTitle("Робуста");
        cofefe.setImage("robysta.jpg");
        request.setAttribute("cofefe", cofefe);
        request.getRequestDispatcher("/jsp/common.jsp").forward(request, response);
    }

}
