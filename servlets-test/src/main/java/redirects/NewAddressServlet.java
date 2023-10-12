package redirects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/address/new")
public class NewAddressServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String htmlResponse = "<h1>EXISTING ADDRESS</h1>";

        resp.addHeader("Content-Type", "text/html");
        resp.setCharacterEncoding("UTF-8");

        resp.getWriter().println(htmlResponse);
        resp.getWriter().flush();
    }
}
