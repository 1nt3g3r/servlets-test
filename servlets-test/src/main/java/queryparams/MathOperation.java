package queryparams;

public enum MathOperation {
    addition,
    multiplication,
    subtraction,
    division;

    public int calculate(int a, int b) {
        switch (this) {
            case addition: return a + b;
            case multiplication: return a * b;
            case subtraction: return a - b;
            case division: return a / b;
        }

        throw new IllegalStateException("calculate(a, b) is not defined for " + this);
    }

    @Override
    public String toString() {
        switch (this) {
            case addition : return "+";
            case multiplication: return "*";
            case subtraction: return "-";
            case division: return "/";
        }

        throw new IllegalStateException("toString() is not defined for " + this);
    }
}
