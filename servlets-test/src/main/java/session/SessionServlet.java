package session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

@WebServlet("/sessions")
public class SessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);

        //Display
        resp.getWriter().println("SESSION ID: " + session.getId());
        resp.getWriter().println("<br>");

        Enumeration<String> attributeNames = session.getAttributeNames();
        while(attributeNames.hasMoreElements()) {
            String attributeName = attributeNames.nextElement();

            Object attribute = session.getAttribute(attributeName);

            resp.getWriter().println(attributeName + "=" + attribute);
            resp.getWriter().println("<br>");
        }

        //Add
        Map<String, String[]> params = req.getParameterMap();
        for (String name : params.keySet()) {
            String value = params.get(name)[0];

            session.setAttribute(name, value);
        }

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().flush();
    }
}
