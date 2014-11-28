package main.java.ru.eltech.cofefe.web.controller;

import main.java.ru.eltech.cofefe.core.entity.CartItem;
import main.java.ru.eltech.cofefe.core.entity.Cofefe;
import main.java.ru.eltech.cofefe.core.entity.Order;
import main.java.ru.eltech.cofefe.core.entity.User;
import main.java.ru.eltech.cofefe.core.provider.CofefeProvider;
import main.java.ru.eltech.cofefe.core.provider.CofefeProviderStub;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.*;

/**
 * Created by Юлия on 23.11.2014.
 */
public class OrderController implements BaseController {

    private CofefeProvider cofefeProvider = CofefeProviderStub.getInstance();

    @Override
    public void handleGetRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String requestURI = request.getRequestURI();
        if (requestURI.contains("checkout")) {
            checkout(request,response);
            return;
        }
        list(request, response);
    }

    @Override
    public void handlePostRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    }

    private void list(final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException {
//
//       request.setAttribute("content", "order.jsp");
//        HttpSession session = request.getSession();
//        Object o = session.getAttribute("cart");
//        Map<Long, CartItem> cart = null;
//        if (o != null) {
//            cart = (Map<Long, CartItem>) o;
//        } else {
//            cart = new HashMap<Long, CartItem>();
//            session.setAttribute("cart", cart);
//        }
//        List<CartItem> list = new LinkedList<>();
//        for (CartItem cartItem : cart.values()) {
//            list.add(cartItem);
//        }
//        request.setAttribute("cart", list);
//        request.getRequestDispatcher("/jsp/common.jsp").forward(request, response);

        request.setAttribute("content", "order.jsp");
        HttpSession session = request.getSession();
        Object o = session.getAttribute("cart");
        Map<Long, Cofefe> cart = null;
        if (o != null) {
            cart = (Map<Long, Cofefe>) o;
        } else {
            cart = new HashMap<Long, Cofefe>();
            session.setAttribute("cart", cart);
        }
        List<Cofefe> list = new LinkedList<>();
        for (Cofefe cartItem : cart.values()) {
            list.add(cartItem);
        }
        request.setAttribute("cart", list);
        request.getRequestDispatcher("/jsp/common.jsp").forward(request, response);
    }

    private void checkout(final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException {
        //EntityManager em = Persistence.createEntityManagerFactory("COFEFE").createEntityManager();
       request.setAttribute("content", "order.jsp");
       HttpSession session = request.getSession();

        Order order = new Order();


        order.setDate(new Date());
        order.setAddress("блааааа");


        Object o = session.getAttribute("cart");
        Map<Long, Cofefe> cart = null;
        if (o != null) {
            cart = (Map<Long, Cofefe>) o;
        } else {
            cart = new HashMap<Long, Cofefe>();
            session.setAttribute("cart", cart);
        }
        List<Cofefe> list = new LinkedList<>();
        CofefeService cofefeService = new CofefeService();
        for (Cofefe cartItem : cart.values()) {
            list.add(cartItem);
             cofefeService.add(cartItem);
           // order.setQuantity(cartItem.get);
        }
        order.setProducts(list);
        OrderService orderService = new OrderService();


        List<Order> ord = new LinkedList<>();
        ord.add(order);


        String login = request.getUserPrincipal().getName();
        UserService userService = new UserService();
        List<User> user = userService.findByLogin(login);
        User usr = user.get(0);
        usr.setOrders(ord);
        orderService.add(order);;//добавляет запись в таблицу заказов
        userService.update(usr); //обновляет соответствующую запись в таблице пользователей


        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", true);

        response.getOutputStream().print(jsonObject.toJSONString());
    }


}
