package at.bbrz.rechner;

import at.bbrz.forms.Form;

import java.util.List;

public class UmfangRechner extends AbstractRechner {
    public UmfangRechner() {
        this.outputMessage = "Umfangsummen: ";
    }

    @Override
    public double sum(List<Form> forms) throws IllegalArgumentException {

        checkIfNullOrEmpty(forms);

        double result = forms.stream().mapToDouble(f -> f.umfang()).sum();

        throwsExceptionWhenCalculationIsInfinite(result);

        return result;
    }


    @Override
    public double max(List<Form> forms) throws IllegalArgumentException {

        checkIfNullOrEmpty(forms);

        double result = forms.stream().mapToDouble(f -> f.umfang()).max().getAsDouble();

        throwsExceptionWhenCalculationIsInfinite(result);

        return result;
    }

    @Override
    public double min(List<Form> forms) throws IllegalArgumentException {

        checkIfNullOrEmpty(forms);

        double result = forms.stream().mapToDouble(f -> f.umfang()).min().getAsDouble();

        throwsExceptionWhenCalculationIsInfinite(result);

        return result;
    }

    @Override
    public double avg(List<Form> forms) throws IllegalArgumentException {

        checkIfNullOrEmpty(forms);

        double result = forms.stream().mapToDouble(f -> f.umfang()).average().getAsDouble();

        throwsExceptionWhenCalculationIsInfinite(result);

        return result;
    }
}
