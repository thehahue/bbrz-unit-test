package at.bbrz.rechner;

import at.bbrz.forms.Form;

import java.util.List;

public class FlaechenRechner extends AbstractRechner {


    @Override
    public String getSummenText() {
        return "Flächensummen: ";
    }

    @Override
    public String getMinText() {
        return "Kleinste Fläche: ";
    }

    @Override
    public double sum(List<Form> forms) throws IllegalArgumentException {

        checkIfNullOrEmpty(forms);

        double result = forms.stream().mapToDouble(f -> f.flaeche()).sum();

        throwsExceptionWhenCalculationIsInfinite(result);

        return result;
    }

    @Override
    public double max(List<Form> forms) throws IllegalArgumentException {
        checkIfNullOrEmpty(forms);

         double result = forms.stream().mapToDouble(f -> f.flaeche()).max().getAsDouble();

         throwsExceptionWhenCalculationIsInfinite(result);
         
         return result;
    }

    @Override
    public double min(List<Form> forms) throws IllegalArgumentException {
        checkIfNullOrEmpty(forms);

        double result = forms.stream().mapToDouble(f -> f.flaeche()).min().getAsDouble();

        throwsExceptionWhenCalculationIsInfinite(result);

        return result;
    }

    @Override
    public double avg(List<Form> forms) throws IllegalArgumentException {

        checkIfNullOrEmpty(forms);

        double result = forms.stream().mapToDouble(f -> f.flaeche()).average().getAsDouble();

        throwsExceptionWhenCalculationIsInfinite(result);

        return result;
    }


}
