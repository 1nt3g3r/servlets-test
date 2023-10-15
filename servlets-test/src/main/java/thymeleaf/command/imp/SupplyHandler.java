package thymeleaf.command.imp;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import thymeleaf.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

public class SupplyHandler implements Command {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, TemplateEngine engine) {
        Map<String, Object> params = new LinkedHashMap<>();

        Context simpleContext = new Context(
                request.getLocale(),
                params
        );

        try {
            engine.process("supply", simpleContext, response.getWriter());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
