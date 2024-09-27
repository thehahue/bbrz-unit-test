package at.bbrz.rechner;

import at.bbrz.forms.Form;

import java.util.List;

public class UmfangRechner extends AbstractRechner {
    @Override
    public double sum(List<Form> forms) throws IllegalArgumentException {
        checkIfNullOrEmpty(forms);

        return forms.stream().mapToDouble(f -> f.umfang()).sum();
    }


    @Override
    public double max(List<Form> forms) throws IllegalArgumentException {
        checkIfNullOrEmpty(forms);
        double max = 0;

        for (Form form : forms) {
            if (form.umfang() > max) {
                max = form.umfang();
            }
        }

        return max;
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
