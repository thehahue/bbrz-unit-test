package at.bbrz.forms;

public class Kreis extends AbstractForm {
    private final double r;

    public Kreis(double r) {
        this.r = r;
        validateInstanceVariables();
    }

    @Override
    public double flaeche() {
        double result = r * r * Math.PI;

        throwsExceptionWhenCalculationIsInfinite(result);

        return roundWithTwoDecimalPlaces(result);
    }

    @Override
    public double umfang() {
        double result = 2 * r * Math.PI;

        throwsExceptionWhenCalculationIsInfinite(result);

        return roundWithTwoDecimalPlaces(result);
    }

    protected void validateInstanceVariables() {
        if (r <= 0) {
            throw new IllegalArgumentException("Radius must not be zero or negative.");
        }
    }
}
