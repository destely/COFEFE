package main.java.ru.eltech.cofefe.web.controller;

import main.java.ru.eltech.cofefe.core.entity.CartItem;
import main.java.ru.eltech.cofefe.core.entity.Cofefe;
import main.java.ru.eltech.cofefe.core.entity.Order;
import main.java.ru.eltech.cofefe.core.entity.User;
import main.java.ru.eltech.cofefe.core.provider.CofefeProvider;
import main.java.ru.eltech.cofefe.core.provider.CofefeProviderStub;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Юлия on 23.11.2014.
 */
public class OrderController implements BaseController {

    private CofefeProvider cofefeProvider = CofefeProviderStub.getInstance();

    @Override
    public void handleGetRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String requestURI = request.getRequestURI();
        if (requestURI.contains("checkout")) {
            checkout(request, response);//вызов метода
        } else {
            list(request, response);
        }
    }

    @Override
    public void handlePostRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    }

    private void list(final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException {

       request.setAttribute("content", "order.jsp");
        HttpSession session = request.getSession();
        Object o = session.getAttribute("cart");
        Map<Long, CartItem> cart = null;
        if (o != null) {
            cart = (Map<Long, CartItem>) o;
        } else {
            cart = new HashMap<Long, CartItem>();
            session.setAttribute("cart", cart);
        }
        List<CartItem> list = new LinkedList<>();
        for (CartItem cartItem : cart.values()) {
            list.add(cartItem);
        }
        request.setAttribute("cart", list);
        request.getRequestDispatcher("/jsp/common.jsp").forward(request, response);

    }

    private void checkout(final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException {
        Order order = new Order();
        order.setDate(DateFormat.getDateInstance());
        order.setAddress("блааааа");

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
        List<Order> ord = null;
        ord.add(order);
        User user = new User();
        user.setOrders(ord);
        response.setContentType("text/java");
         PrintWriter out = response.getWriter();
        out.print("Выполнено");
        out.flush();
      // order.setProducts(list);

        /*String query = request.getParameter("query");
        List<Cofefe> result = cofefeProvider.search(query);
        JSONObject object = new JSONObject();
        JSONArray array = new JSONArray();
        object.put("result", array);
        for (Cofefe cofefe : result) {
            JSONObject _object = new JSONObject();
            _object.put("title", cofefe.getTitle());
            _object.put("description", cofefe.getShortDescription());
            _object.put("image", cofefe.getImage());
            _object.put("id", cofefe.getId());
            array.add(_object);
        }
        response.setContentType("application/json");
        //  response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.print(object.toJSONString());
        out.flush();*/
    }


}
