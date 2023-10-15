package thymeleaf.command;

import org.thymeleaf.TemplateEngine;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
    void handle(HttpServletRequest request, HttpServletResponse response, TemplateEngine engine);
}
