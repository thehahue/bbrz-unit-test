package at.bbrz.forms;

import java.util.List;

public class FlaechenRechner implements Rechner{

    @Override
    public double sum(List<Form> forms) throws IllegalArgumentException {

        checkIfNullOrEmpty(forms);

        return forms.stream().mapToDouble(f -> f.flaeche()).sum();
    }

    @Override
    public double max(List<Form> forms) throws IllegalArgumentException {
        return 0;
    }

    @Override
    public double min(List<Form> forms) throws IllegalArgumentException {
        return 0;
    }

    @Override
    public double avg(List<Form> forms) throws IllegalArgumentException {
        return 0;
    }

    private void checkIfNullOrEmpty(List<Form> forms) {
        if (forms == null || forms.isEmpty()) {
            throw new IllegalArgumentException("List must not be empty or null.");
        }
    }
}
