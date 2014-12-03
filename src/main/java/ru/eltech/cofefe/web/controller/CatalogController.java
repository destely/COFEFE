package main.java.ru.eltech.cofefe.web.controller;

import main.java.ru.eltech.cofefe.core.entity.Cofefe;
import main.java.ru.eltech.cofefe.core.provider.CofefeProvider;
import main.java.ru.eltech.cofefe.core.provider.CofefeProviderStub;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by destely on 19.10.2014.
 */
public class CatalogController implements BaseController {

    private CofefeProvider cofefeProvider = CofefeProviderStub.getInstance();

    @Override
    public void handlePostRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    }

    @Override
    public void handleGetRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("content", "catalog.jsp");
        String requestURI = request.getRequestURI();//путь запроса без парам
        if (requestURI.contains("search")) {
            search(request, response);//вызов метода
        } else {
            List<Cofefe> cofefeList = cofefeProvider.getAll();
            request.setAttribute("list", cofefeList);
            request.getRequestDispatcher("/jsp/common.jsp").forward(request, response);
        }
    }

    private void search(final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException {
        String query = request.getParameter("query");
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
        PrintWriter out = response.getWriter();
        out.print(object.toJSONString());
        out.flush();
}
}
