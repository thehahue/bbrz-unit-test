package at.bbrz.forms;

import java.util.List;

public class UmfangRechner implements Rechner {
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

    private void checkIfNullOrEmpty(List<Form> forms) {
        if (forms == null || forms.isEmpty()) {
            throw new IllegalArgumentException("List must not be empty or null.");
        }
    }
}
