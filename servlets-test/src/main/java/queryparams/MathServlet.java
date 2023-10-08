package queryparams;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

@WebServlet("/math")
public class MathServlet extends HttpServlet {
    // /math?a=1&b=5&operation=multiplication
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InputDataParser parsedData = new InputDataParser(req);

        if (!parsedData.isParsed()) {
            String errors = String.join("\n", parsedData.getErrors());
            resp.getWriter().println(errors);
        } else {
            int a = parsedData.getA();
            int b = parsedData.getB();

            StringJoiner operationsResult = new StringJoiner("\n");
            operationsResult.add("<ul>");

            for (MathOperation mathOperation: parsedData.getMathOperations()) {
                int result = mathOperation.calculate(a, b);
                String operationChar = mathOperation.toString();

                String responseTemplate = "${a} ${operation} ${b} = ${result}";
                String response = responseTemplate
                        .replace("${a}", Integer.toString(a))
                        .replace("${b}", Integer.toString(b))
                        .replace("${operation}", operationChar)
                        .replace("${result}", Integer.toString(result));

                operationsResult.add("<li>" + response + "</li>");
            }
            operationsResult.add("</ul>");

            resp.getWriter().println(operationsResult);
        }

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().flush();
    }
}
