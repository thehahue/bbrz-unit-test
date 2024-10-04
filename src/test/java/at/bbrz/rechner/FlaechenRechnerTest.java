package at.bbrz.rechner;

import at.bbrz.TestHelper;
import at.bbrz.forms.Form;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FlaechenRechnerTest {

    FlaechenRechner flaechenRechner;
    List<Form> forms;
    @BeforeEach
    void setUp() {
        flaechenRechner = new FlaechenRechner();
        forms = List.of(
                new TestHelper.TestForm(),
                new TestHelper.TestFormWithParameters(2.5, 5.1),
                new TestHelper.TestFormWithParameters(62.1, 1.66));
    }

    @Test
    void calculateSumOfList_forms() {
        double sum = flaechenRechner.sum(forms);
        assertEquals(201.67,sum,0.01);
    }

    @Test
    void throwsException_whenListForSumIsEmpty() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            flaechenRechner.sum(List.of());
        });

        assertEquals("List must not be empty or null.", exception.getMessage());
    }

    @Test
    void throwsException_whenListForSumIsNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            flaechenRechner.sum(null);
        });

        assertEquals("List must not be empty or null.", exception.getMessage());
    }

    @Test
    void calculateMaxOfList() {
        double max = flaechenRechner.max(forms);

        assertEquals(187.96, max);
    }

    @Test
    void throwsException_whenListForMaxIsEmpty() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            flaechenRechner.max(List.of());
        });

        assertEquals("List must not be empty or null.", exception.getMessage());
    }

    @Test
    void throwsException_whenListForMaxIsNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            flaechenRechner.max(null);
        });

        assertEquals("List must not be empty or null.", exception.getMessage());
    }

    @Test
    void calculateMinOfList() {
        double min = flaechenRechner.min(forms);

        assertEquals(1.111, min);
    }

    @Test
    void throwsException_whenListForMinIsEmpty() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            flaechenRechner.min(List.of());
        });

        assertEquals("List must not be empty or null.", exception.getMessage());
    }

    @Test
    void throwsException_whenListForMinIsNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            flaechenRechner.min(null);
        });

        assertEquals("List must not be empty or null.", exception.getMessage());
    }

    @Test
    void calculateAvgOfList() {
        double avg = flaechenRechner.avg(forms);

        assertEquals(67.22, avg, 0.01);
    }

    @Test
    void throwsException_whenListForAvgIsEmpty() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            flaechenRechner.avg(List.of());
        });

        assertEquals("List must not be empty or null.", exception.getMessage());
    }

    @Test
    void throwsException_whenListForAvgIsNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            flaechenRechner.avg(null);
        });
    }
}