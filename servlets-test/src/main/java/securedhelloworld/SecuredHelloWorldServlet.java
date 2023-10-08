package securedhelloworld;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/secured-hello-world")
public class SecuredHelloWorldServlet extends HttpServlet {
    private static final String AUTH_HEADER_NAME = "AuthToken";
    private static final String AUTH_HEADER_VALUE = "fdsbt65ehBTRTHef4ewg";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String headerValue = req.getHeader(AUTH_HEADER_NAME);

        if (AUTH_HEADER_VALUE.equals(headerValue)) {
            resp.getWriter().write("Hello World, authorized user");
            resp.setContentType("text/html");
            resp.setCharacterEncoding("UTF-8");
        } else {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }
}
