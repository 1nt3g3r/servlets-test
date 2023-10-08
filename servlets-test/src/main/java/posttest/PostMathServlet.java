package posttest;

import queryparams.InputDataParser;
import queryparams.MathOperation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.StringJoiner;
import java.util.stream.Collectors;

@WebServlet("/math-post")
public class PostMathServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String form = "<form method=\"POST\">\n" +
                "    <label>A</label>\n" +
                "    <input name=\"a\" type=\"number\"> <br>\n" +
                "\n" +
                "    <label>B</label>\n" +
                "    <input name=\"b\" type=\"number\"> <br>\n" +
                "\n" +
                "    <label>Operation</label>\n" +
                "    <input name=\"operation\" type=\"text\"> <br>\n" +
                "\n" +
                "    <button type=\"submit\">Calculate</button>\n" +
                "</form>";

        resp.getWriter().println(form);
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestData = req.getReader().lines().collect(Collectors.joining());

        resp.getWriter().write(requestData);

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().flush();
    }
}
