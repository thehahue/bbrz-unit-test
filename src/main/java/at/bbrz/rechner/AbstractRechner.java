package at.bbrz.rechner;

import at.bbrz.forms.Form;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public abstract class AbstractRechner implements Rechner {
    protected String rechnerName;

    public String getRechnerName(){
        return rechnerName;
    }

    protected void checkIfNullOrEmpty(List<Form> forms) {
        if (forms == null || forms.isEmpty()) {
            throw new IllegalArgumentException("List must not be empty or null.");
        }
    }

    protected double roundWithTwoDecimalPlaces(double result) {
        BigDecimal bd = new BigDecimal(Double.toString(result));
        bd = bd.setScale(2, RoundingMode.HALF_UP);

        return bd.doubleValue();
    }
}
