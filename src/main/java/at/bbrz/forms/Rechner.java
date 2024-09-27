package at.bbrz.forms;

import java.util.List;

public interface Rechner {
    double sum(List<Form> forms) throws IllegalArgumentException;
}
