package queryparams;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class InputDataParser {
    private boolean parsed;
    List<String> errors;

    private int a;
    private int b;
    private List<MathOperation> mathOperations;

    public InputDataParser(HttpServletRequest request) {
        parsed = true;
        errors = new ArrayList<>();

        try {
            a = parseIntValue("a", request);
        } catch (Exception ex) {
            parsed = false;
            errors.add("Parameter 'a' is missing or has wrong format");
        }

        try {
            b = parseIntValue("b", request);
        } catch (Exception ex) {
            parsed = false;
            errors.add("Parameter 'b' is missing or has wrong format");
        }

        try {
            mathOperations = new ArrayList<>();

            String[] operations = request.getParameterValues("operation");
            for (String operation : operations) {
                mathOperations.add(MathOperation.valueOf(operation));
            }
        } catch (Exception ex) {
            parsed = false;
            errors.add("Parameter 'operations' is missing or has wrong format");
        }
    }

    private int parseIntValue(String param, HttpServletRequest request) {
        String value = request.getParameter(param);
        return Integer.parseInt(value);
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public List<MathOperation> getMathOperations() {
        return new ArrayList<>(mathOperations);
    }

    public boolean isParsed() {
        return parsed;
    }

    public List<String> getErrors() {
        return new ArrayList<>(errors);
    }
}
