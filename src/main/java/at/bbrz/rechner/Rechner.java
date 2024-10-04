package at.bbrz.rechner;

import at.bbrz.forms.Form;

import java.util.List;

public interface Rechner {
    String getOutputMessage();
    double sum(List<Form> forms) throws IllegalArgumentException;
    double max(List<Form> forms) throws IllegalArgumentException;
    double min(List<Form> forms) throws IllegalArgumentException;
    double avg(List<Form> forms) throws IllegalArgumentException;
}
