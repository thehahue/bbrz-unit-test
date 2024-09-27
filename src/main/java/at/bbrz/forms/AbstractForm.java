package at.bbrz.forms;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class AbstractForm implements Form {
    protected void throwsExceptionWhenCalculationIsInfinite(double result) {
        if (Double.isInfinite(result)) {
            throw new IllegalArgumentException("Calculation overflow.");
        }
    }

    protected double roundWithTwoDecimalPlaces(double result) {
        BigDecimal bd = new BigDecimal(Double.toString(result));
        bd = bd.setScale(2, RoundingMode.HALF_UP);

        return bd.doubleValue();
    }

    protected abstract void validateParameter();
}
