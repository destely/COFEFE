package main.java.ru.eltech.cofefe.web.controller;

import main.java.ru.eltech.cofefe.web.controller.CartController;
import main.java.ru.eltech.cofefe.core.entity.CartItem;
import main.java.ru.eltech.cofefe.core.entity.Cofefe;
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
 * Created by Юлия on 23.11.2014.
 */
public class OrderController implements BaseController {

    private CofefeProvider cofefeProvider = CofefeProviderStub.getInstance();

    @Override
    public void handleGetRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //request.setAttribute("content", "order.jsp");
        // request.getRequestDispatcher("/jsp/common.jsp").forward(request, response);

             list(request, response);
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
}
