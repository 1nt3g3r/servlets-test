package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/cookies")
public class CookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> params = req.getParameterMap();

        for (String name : params.keySet()) {
            String value = params.get(name)[0];

            resp.addHeader("Set-Cookie", name + "=" + value);

//            Cookie cookie = new Cookie(name, value);
//            resp.addCookie(cookie);
        }



        resp.getWriter().write("<h1>Cookie worker</h1>");

        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            resp.getWriter().println(cookie.getName() + "=" + cookie.getValue());
        }

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        resp.getWriter().flush();
    }
}
