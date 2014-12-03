package main.java.ru.eltech.cofefe.web.controller;

import main.java.ru.eltech.cofefe.core.entity.*;
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
import java.util.*;

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
        String requestURI = request.getRequestURI();
        if (requestURI.contains("setComment")) {
            setComment(request, response);
            return;
        }
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
        CommentService commentService = new CommentService();
        List<Comment> comments_list = commentService.getAll();

        request.setAttribute("content", "profile.jsp");
        request.setAttribute("initTab", initTab);
        request.setAttribute("cofefe", cofefe);
        request.setAttribute("comments_list", comments_list);
        request.getRequestDispatcher("/jsp/common.jsp").forward(request, response);
    }

    @Override
    public void handlePostRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    }

    private void setComment(final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException {
       request.setAttribute("content", "profile.jsp");
       // HttpSession session = request.getSession();
        String text = request.getParameter("text");
        Comment comment = new Comment();
        CommentService commentService = new CommentService();
        comment.setDate(new Date());
        comment.setText(text);

        commentService.add(comment);

     /*   List<Comment> result = commentService.getAll();
        JSONObject object = new JSONObject();
        JSONArray array = new JSONArray();
        object.put("result", array);
        for (Comment com : result) {
            JSONObject _object = new JSONObject();
            _object.put("date", com.getDate());
            _object.put("text", com.getText());
            array.add(_object);
        }
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(object.toJSONString());
        out.flush();
*/

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", true);
        response.getOutputStream().print(jsonObject.toJSONString());



    }


}
