package at.bbrz.rechner;

import at.bbrz.forms.Form;

import java.util.List;

public class UmfangRechner extends AbstractRechner {
    public UmfangRechner() {
        this.rechnerName = "Umfang";
    }

    @Override
    public double sum(List<Form> forms) throws IllegalArgumentException {

        checkIfNullOrEmpty(forms);

        return roundWithTwoDecimalPlaces(forms.stream().mapToDouble(f -> f.umfang()).sum());
    }


    @Override
    public double max(List<Form> forms) throws IllegalArgumentException {

        checkIfNullOrEmpty(forms);

        return forms.stream().mapToDouble(f -> f.umfang()).max().getAsDouble();
    }

    @Override
    public double min(List<Form> forms) throws IllegalArgumentException {

        checkIfNullOrEmpty(forms);

        return forms.stream().mapToDouble(f -> f.umfang()).min().getAsDouble();
    }

    @Override
    public double avg(List<Form> forms) throws IllegalArgumentException {

        checkIfNullOrEmpty(forms);

        return forms.stream().mapToDouble(f -> f.umfang()).average().getAsDouble();
    }
}
