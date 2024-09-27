package at.bbrz.forms;

import java.util.List;

public class UmfangRechner implements Rechner {
    @Override
    public double sum(List<Form> forms) throws IllegalArgumentException {
//        double sum = 0;
//
//        for (Form form : forms) {
//            sum += form.umfang();
//        }
//
//        return sum;
        if (forms == null || forms.isEmpty()) {
            throw new IllegalArgumentException("List must not be empty or null.");
        }

        return forms.stream().mapToDouble(f -> f.umfang()).sum();
    }
}
