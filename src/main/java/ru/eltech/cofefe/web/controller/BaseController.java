package main.java.ru.eltech.cofefe.web.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by destely on 19.10.2014.
 */
public interface BaseController {

    public void handleGetRequest(final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException;

    public void handlePostRequest(final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException;

}
