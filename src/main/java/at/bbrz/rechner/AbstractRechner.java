package at.bbrz.rechner;

import at.bbrz.forms.Form;

import java.util.List;

public abstract class AbstractRechner implements Rechner {
    protected void checkIfNullOrEmpty(List<Form> forms) {
        if (forms == null || forms.isEmpty()) {
            throw new IllegalArgumentException("List must not be empty or null.");
        }
    }
}
