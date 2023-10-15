package thymeleaf.command;

import org.thymeleaf.TemplateEngine;
import thymeleaf.command.imp.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class CommandHandler {
    private Map<String, Command> handlers;

    public CommandHandler() {
        handlers = new HashMap<>();

        handlers.put("GET /drone/supply", new SupplyHandler());
        handlers.put("POST /drone/supply/wings", new AddWingsSupplyHandler());
        handlers.put("POST /drone/supply/frame", new AddFrameSupplyHandler());
        handlers.put("POST /drone/supply/electronics", new AddElectronicsSupplyHandler());

        handlers.put("GET /drone/stats", new DroneStatsHandler());

        handlers.put("GET /drone/assemble", new ShowAssembleHandler());
        handlers.put("POST /drone/assemble", new AssembleAndSendHandler());
    }

    public void handle(HttpServletRequest request, HttpServletResponse response, TemplateEngine engine) {
        String method = request.getMethod();
        String requestURI = request.getRequestURI();

        String commandKey = method.toUpperCase() + " " + requestURI;
        commandKey = commandKey.replace("/servlets_test_war", "");

        Command command = handlers.get(commandKey);

        command.handle(request, response, engine);
    }

}
