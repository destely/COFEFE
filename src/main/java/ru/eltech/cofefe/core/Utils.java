package main.java.ru.eltech.cofefe.core;

import java.util.*;
import java.util.ResourceBundle;
import javax.servlet.http.HttpServletRequest;


public class Utils {

    //  static private ResourceBundle resourceBundle;

    static public ResourceBundle getResourceBundle(final HttpServletRequest request, String langPar) {
        Locale loc = Locale.ENGLISH;
        Enumeration<String> params = request.getParameterNames();
        while (params.hasMoreElements())
        {
            String t = params.nextElement();
            if (t.equals("locale"))
            {
                loc = new Locale(request.getParameter(t));
            }
        }
        return ResourceBundle.getBundle("main.java.ru.eltech.cofefe", loc);
    }

}
