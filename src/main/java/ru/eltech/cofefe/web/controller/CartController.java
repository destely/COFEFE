package main.java.ru.eltech.cofefe.web.controller;

import main.java.ru.eltech.cofefe.core.entity.CartItem;
import main.java.ru.eltech.cofefe.core.entity.Cofefe;
import main.java.ru.eltech.cofefe.core.entity.User;
import main.java.ru.eltech.cofefe.core.provider.CofefeProvider;
import main.java.ru.eltech.cofefe.core.provider.CofefeProviderStub;
import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by destely on 03.11.2014.
 */
public class CartController implements BaseController {

    private CofefeProvider cofefeProvider = CofefeProviderStub.getInstance();

    @Override
    public void handleGetRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String requestURI = request.getRequestURI();
        if (requestURI.contains("update")) {
            update(request, response);
        } else if (requestURI.contains("remove")) {
            remove(request, response);
        } else if (requestURI.contains("order")) {
            order(request, response);
        }  else {
            list(request, response);
        }
    }

    @Override
    public void handlePostRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }

    private void update (final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException {
        String idString = request.getParameter("id");
        Long id = Long.parseLong(idString);
        Cofefe cofefe = cofefeProvider.getById(id);
        HttpSession session = request.getSession();
        Object o = session.getAttribute("cart");
        CartItem cartItem = null;
        Map<Long, CartItem> cart = null;
        if (o != null) {
            cart = (Map<Long, CartItem>) o;
        } else {
            cart = new HashMap<>();
            session.setAttribute("cart", cart);
        }
        cartItem = cart.get(id);
        if (cartItem == null) {
            cartItem = new CartItem(cofefe);
        }
        int quantity = cartItem.getQuantity();
        String valueString = request.getParameter("value");
        Long value = Long.parseLong(valueString);
        int oldQuantity  = quantity;
        quantity += value;
        JSONObject jsonObject = new JSONObject();
        if (value < 0) {
            jsonObject.put("success", false);
            jsonObject.put("quantity", oldQuantity);
        } else {
            cart.put(id, cartItem);
            cartItem.setQuantity(quantity);
            jsonObject.put("success", true);
            jsonObject.put("quantity", quantity);
        }
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(jsonObject.toJSONString());
        out.flush();
    }

    private void list(final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("content", "cart.jsp");
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

    private void remove(final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("content", "cart.jsp");
        HttpSession session = request.getSession();
        Object o = session.getAttribute("cart");
        String idString = request.getParameter("id");
        Long id = Long.parseLong(idString);
        Map<Long, CartItem> cart = null;
        if (o != null) {
            cart = (Map<Long, CartItem>) o;
        } else {
            cart = new HashMap<Long, CartItem>();
            session.setAttribute("cart", cart);
        }
        CartItem item = cart.get(id);
       // cart.remove(id);
        if (item != null) {
            int quantity = item.getQuantity();
            if (quantity > 1) {
                item.setQuantity(quantity - 1);
            } else {
                cart.remove(id);
            }
        }
        response.sendRedirect("/cofefe/app/cart");
    }

    private void order(final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("content", "cart.jsp");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("/cofefe/app/auth");
        } else {
            response.sendRedirect("/cofefe/app/cart");
        }
    }

}
