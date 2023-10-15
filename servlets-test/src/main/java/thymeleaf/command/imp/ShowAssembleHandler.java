package thymeleaf.command.imp;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import thymeleaf.DroneFactory;
import thymeleaf.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class ShowAssembleHandler implements Command {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, TemplateEngine engine) {
        DroneFactory factory = DroneFactory.getInstance();

        int assembledDrones = factory.getAssembledDrones();
        boolean canAssembleDrone = factory.getPossibleDrones() > 0;

        Map<String, Object> params = new LinkedHashMap<>();
        params.put("assembledDrones", assembledDrones);
        params.put("canAssembleDrone", canAssembleDrone);

        Context simpleContext = new Context(
                request.getLocale(),
                params
        );

        try {
            engine.process("assemble", simpleContext, response.getWriter());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
