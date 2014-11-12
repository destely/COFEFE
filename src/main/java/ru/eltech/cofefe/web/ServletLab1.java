package main.java.ru.eltech.cofefe.web;

import main.java.ru.eltech.cofefe.core.UTF8ResourceBundle;
//import main.java.ru.eltech.cofefe.core.Utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by destely on 19.10.2014.
 */
public class ServletLab1 extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String defLang = getInitParameter("lang_par");
        ResourceBundle res = new UTF8ResourceBundle("main.java.ru.eltech.cofefe.lang", Locale.ENGLISH);


        String reviews = res.getString("REVIEWS");
        String details = res.getString("DETAILS");
        String sh_dscrptn = res.getString("SH_DSCRPTN");
        String lng_dscrptn = res.getString("LNG_DSCRPTN");
        String add_to_cart = res.getString("ADD_TO_CART");
        String delivery = res.getString("DELIVERY");
        String contacts = res.getString("CONTACTS");
        String elite = res.getString("ELITE");
        String classic = res.getString("CLASSIC");
        String espresso = res.getString("ESPRESSO");
        String flavored = res.getString("FLAVORED");
        String instant = res.getString("INSTANT");
        String green = res.getString("GREEN");
        String decaffeinated = res.getString("DECAFFEINATED");
        String robysta = res.getString("ROBYSTA");
        String price = res.getString("PRICE");
        String title = robysta;

        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<head>");
            out.println("<script src='js/mjs.js'></script>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"/cofefe/css/style.css\">");
            out.print("<title>");
            out.print(title);
            out.println("</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"menu-bar\"></div>");

            out.println("<a href=\"Robusta?locale=ru\">Русский</a>");
            out.println("<a href=\"Robusta?locale=en\">Английский</a>");
            out.println("<a href=\"Robusta?locale=de\">Немецкий</a>");

            out.println("<div class=\"sidebar\">");


            out.println("<div class=\"elem1\"><h2>" + elite + "</h2></div>");
            out.println("<div class=\"elem2\"><h2>" + classic + "</h2></div>");
            out.println("<div class=\"elem3\"><h2>" + espresso + "</h2></div>");
            out.println("<div class=\"elem4\"><h2>" + flavored + "</h2></div>");
            out.println("<div class=\"elem5\"><h2>" + instant + "</h2></div>");
            out.println("<div class=\"elem6\"><h2>" + green + "</h2></div>");
            out.println("<div class=\"elem7\"><h2>" + decaffeinated + "</h2></div>");

            out.println("<div class=\"topbar\">");
            out.println("<div class=\"el1\"><h2>" + delivery + "</h2></div>");
            out.println("<div class=\"el2\"><h2>" + contacts + "</h2></div></div>");
            out.println("<div class=\"title_elem\">" + robysta + "</div>");
            out.println("<div class=\"price_elem\">" + price + "</div>");
            out.println("<div class=\"img_panel\"><img src=\"images/robysta.jpg\"/>");
            out.println("<div class=\"komment\">");
            out.println("<div class=\"bubekk\">"
                    + "<a onclick=\"show_hide('inform');\" href=\"#\">" + reviews + "</a>"
                    + "</div>");
            out.println("<div id='content1'><div id=\"inform\">Отзывы отсутствуют.</div></div></div></div>");

            out.println("<div class=\"info_elem\">" + sh_dscrptn + "</div>");
            out.println("<div class=\"info_elem_ss\">");
            out.println("<div class=\"bubek\">"
                    + " <a onclick=\"show_hide('info')\" href=\"#\">" + details + "</a>"
                    + "</div>");
            out.println("<div class=\"el3\"><h1>" + add_to_cart + "</h1></div></div>");
            out.println("<div id='content'><div id=\"info\">" + lng_dscrptn + "</div></div>");

            out.println("</body></html>");

        }
    }
}

