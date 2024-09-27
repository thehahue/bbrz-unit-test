package at.bbrz.forms;

public class Kreis extends AbstractForm {
    private double r;

    public Kreis(double r) {
        this.r = r;
        validateParameter();
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

    protected void validateParameter() {
        if (r <= 0) {
            throw new IllegalArgumentException("Radius must not be zero or negative.");
        }
    }
}
