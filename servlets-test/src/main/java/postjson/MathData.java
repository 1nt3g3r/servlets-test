package postjson;

import queryparams.MathOperation;

import java.util.List;

public class MathData {
    private int a;
    private int b;
    private List<MathOperation> operations;

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public List<MathOperation> getOperations() {
        return operations;
    }

    @Override
    public String toString() {
        return "MathData{" +
                "a=" + a +
                ", b=" + b +
                ", operations=" + operations +
                '}';
    }
}
