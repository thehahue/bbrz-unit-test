package at.bbrz.forms;

public class Rechteck extends AbstractForm {
    private final double a;
    private final double b;

    public Rechteck(double a, double b) {
        this.a = a;
        this.b = b;
        validateInstanceVariables();
    }

    @Override
    public double flaeche() {
        double result = a * b;

        throwsExceptionWhenCalculationIsInfinite(result);

        return result;
    }

    @Override
    public double umfang() {
        double result = 2 * a + 2 * b;

        throwsExceptionWhenCalculationIsInfinite(result);

        return result;
    }

    protected void validateInstanceVariables() {
        if (a <= 0 || b <= 0) {
            throw new IllegalArgumentException("Values must not be zero or negative.");
        }
    }

}
