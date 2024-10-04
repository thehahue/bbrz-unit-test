package at.bbrz.rechner;

import at.bbrz.forms.Form;

import java.util.List;

public abstract class AbstractRechner implements Rechner {
    protected String outputMessage;

    public String getOutputMessage(){
        return outputMessage;
    }

    protected void checkIfNullOrEmpty(List<Form> forms) {
        if (forms == null || forms.isEmpty()) {
            throw new IllegalArgumentException("List must not be empty or null.");
        }
    }

    protected void throwsExceptionWhenCalculationIsInfinite(double result) {
        if (Double.isInfinite(result)) {
            throw new IllegalArgumentException("Calculation overflow.");
        }
    }


}
