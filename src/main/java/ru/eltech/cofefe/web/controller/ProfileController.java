package main.java.ru.eltech.cofefe.web.controller;

import main.java.ru.eltech.cofefe.core.entity.BoughtItem;
import main.java.ru.eltech.cofefe.core.entity.Cofefe;
import main.java.ru.eltech.cofefe.core.entity.Order;
import main.java.ru.eltech.cofefe.core.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

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

        EntityManager em = Persistence.createEntityManagerFactory("COFEFE").createEntityManager();

        String login = request.getUserPrincipal().getName();
        UserService userService = new UserService();
        List<Order> orders = new LinkedList<>();
        List<BoughtItem> cofefe = new LinkedList<>();
        User user = userService.findByLogin(login,em).get(0);

        orders.addAll(user.getOrders());

        for(Order ord: orders) {
            cofefe.addAll(ord.getProducts());
        }


        request.setAttribute("content", "profile.jsp");
        request.setAttribute("initTab", initTab);
        request.setAttribute("cofefe", cofefe);
        request.setAttribute("orders", orders);
        request.getRequestDispatcher("/jsp/common.jsp").forward(request, response);
    }

    @Override
    public void handlePostRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }

}
