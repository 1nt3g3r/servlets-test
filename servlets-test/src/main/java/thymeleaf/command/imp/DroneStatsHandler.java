package thymeleaf.command.imp;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import thymeleaf.DroneFactory;
import thymeleaf.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

public class DroneStatsHandler implements Command {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, TemplateEngine engine) {
        DroneFactory factory = DroneFactory.getInstance();

        int wings = factory.getWings();
        int frames = factory.getFrames();
        int electronics = factory.getElectronics();
        int possibleDroneCount = factory.getPossibleDrones();

        Map<String, Object> params = new LinkedHashMap<>();
        params.put("wings", wings);
        params.put("frames", frames);
        params.put("electronics", electronics);
        params.put("possibleDrones", possibleDroneCount);

        Context simpleContext = new Context(
                request.getLocale(),
                params
        );

        try {
            engine.process("stats", simpleContext, response.getWriter());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
