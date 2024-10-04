package at.bbrz.rechner;

import at.bbrz.forms.Form;

import java.util.List;

public class FlaechenRechner extends AbstractRechner {

    public FlaechenRechner() {
        this.outputMessage = "Flächensummen: ";
    }

    @Override
    public double sum(List<Form> forms) throws IllegalArgumentException {

        checkIfNullOrEmpty(forms);

        double sum = forms.stream().mapToDouble(f -> f.flaeche()).sum();

        return roundWithTwoDecimalPlaces(sum);
    }

    @Override
    public double max(List<Form> forms) throws IllegalArgumentException {
        checkIfNullOrEmpty(forms);

        return forms.stream().mapToDouble(f -> f.flaeche()).max().getAsDouble();
    }

    @Override
    public double min(List<Form> forms) throws IllegalArgumentException {
        checkIfNullOrEmpty(forms);

        return forms.stream().mapToDouble(f -> f.flaeche()).min().getAsDouble();
    }

    @Override
    public double avg(List<Form> forms) throws IllegalArgumentException {

        checkIfNullOrEmpty(forms);

        return forms.stream().mapToDouble(f -> f.flaeche()).average().getAsDouble();
    }


}
