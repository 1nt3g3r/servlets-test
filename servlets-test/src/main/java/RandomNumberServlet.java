import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet("/random")
public class RandomNumberServlet extends HttpServlet {
    private int randomNumber;

    @Override
    public void init() throws ServletException {
        randomNumber = new Random().nextInt();
        System.out.println("INIT CALLED");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String htmlResponse = "<h1>" +randomNumber + "</h1>";

       resp.addHeader("Content-Type", "text/html");
       resp.setCharacterEncoding("UTF-8");

       resp.getWriter().println(htmlResponse);
       resp.getWriter().flush();
    }
}
