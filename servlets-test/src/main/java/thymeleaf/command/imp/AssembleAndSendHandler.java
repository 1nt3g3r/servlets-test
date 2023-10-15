package thymeleaf.command.imp;

import org.thymeleaf.TemplateEngine;
import thymeleaf.DroneFactory;
import thymeleaf.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AssembleAndSendHandler implements Command {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, TemplateEngine engine) {
        DroneFactory factory = DroneFactory.getInstance();
        factory.assembleAndSend();

        try {
            response.sendRedirect("/servlets_test_war/drone/assemble");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
