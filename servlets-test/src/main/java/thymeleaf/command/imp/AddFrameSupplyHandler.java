package thymeleaf.command.imp;

import org.thymeleaf.TemplateEngine;
import thymeleaf.DroneFactory;
import thymeleaf.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddFrameSupplyHandler implements Command {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, TemplateEngine engine) {
        DroneFactory factory = DroneFactory.getInstance();
        factory.setFrames(factory.getFrames() + 1);

        try {
            response.sendRedirect("/servlets_test_war/drone/supply");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
