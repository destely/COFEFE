package main.java.ru.eltech.cofefe.web;

import main.java.ru.eltech.cofefe.core.entity.User;
import main.java.ru.eltech.cofefe.web.controller.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.security.Principal;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Created by destely on 19.10.2014.
 */
public class MainServlet extends HttpServlet {

    private Map<String, BaseController> controllerMap = new HashMap<String, BaseController>();
    private Locale defaultLocale = Locale.ENGLISH;
    private String initTab;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        initTab = config.getInitParameter("initTab");
        controllerMap.put(".*\\/product.*", new ProductController(initTab));
        controllerMap.put(".*\\/catalog.*", new CatalogController());
        controllerMap.put(".*\\/common.*", new CommonController());
        controllerMap.put(".*\\/cart.*", new CartController());
        controllerMap.put(".*\\/auth.*", new AuthController());
        controllerMap.put(".*\\/profile.*", new ProfileController(initTab));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Principal userPrincipal = req.getUserPrincipal();
        if (userPrincipal != null) {
            req.setAttribute("user", userPrincipal.getName());
        }
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
//        User user = (User) session.getAttribute("user");
        String localeString = (String) session.getAttribute("locale");
        if (localeString == null) {
            String curLocaleFromCookie = null;
            for (Cookie cookie : req.getCookies()) {
                if ("locale".equals(cookie.getName())) {
                    curLocaleFromCookie = cookie.getValue();
                    break;
                }
            }
            if (curLocaleFromCookie == null) {
                req.setAttribute("locale", defaultLocale);
            } else {
                Locale locale = new Locale(curLocaleFromCookie);
                session.setAttribute("locale", curLocaleFromCookie);
                req.setAttribute("locale", locale);
            }
        } else {
            Locale locale = new Locale(localeString);
            req.setAttribute("locale", locale);
        }
        resolveControllerByRequest(req).handleGetRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null) {
            req.setAttribute("user", user);
        }
        String localeString = (String) session.getAttribute("locale");
        if (localeString == null) {
            String curLocaleFromCookie = null;
            for (Cookie cookie : req.getCookies()) {
                if ("locale".equals(cookie.getName())) {
                    curLocaleFromCookie = cookie.getValue();
                    break;
                }
            }
            if (curLocaleFromCookie == null) {
                req.setAttribute("locale", defaultLocale);
            } else {
                Locale locale = new Locale(curLocaleFromCookie);
                session.setAttribute("locale", curLocaleFromCookie);
                req.setAttribute("locale", locale);
            }
        } else {
            Locale locale = new Locale(localeString);
            req.setAttribute("locale", locale);
        }
        resolveControllerByRequest(req).handlePostRequest(req, resp);
    }

    private BaseController resolveControllerByRequest(final HttpServletRequest request) {
        String requestUri = request.getRequestURI();
        for (String key : controllerMap.keySet()) {
            if (requestUri.matches(key)) {
                return controllerMap.get(key);
            }
        }
        return controllerMap.get(".*\\/catalog.*");
    }

}
