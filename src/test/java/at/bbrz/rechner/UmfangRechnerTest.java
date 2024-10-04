package at.bbrz.rechner;

import at.bbrz.TestHelper;
import at.bbrz.forms.Form;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UmfangRechnerTest {
    UmfangRechner umfangRechner;
    List<Form> forms = List.of(
            new TestHelper.TestForm(),
            new TestHelper.TestFormWithParameters(5, 5),
            new TestHelper.TestFormWithParameters(Math.PI, 5));

    @BeforeEach
    void setUp() {
        umfangRechner = new UmfangRechner();
    }


    @Test
    void calculateSumOfUmfang() {
        double sum = umfangRechner.sum(forms);

        assertEquals(38.97477, sum, 0.00001);
    }

    @Test
    void throwsException_whenListForSumIsEmpty() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            umfangRechner.sum(List.of());
        });

        assertEquals("List must not be empty or null.", exception.getMessage());
    }

    @Test
    void throwsException_whenListForSumIsNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            umfangRechner.sum(null);
        });

        assertEquals("List must not be empty or null.", exception.getMessage());
    }

    @Test
    void calculateMaxUmfang() {
        double max = umfangRechner.max(forms);

        assertEquals(20, max);
    }

    @Test
    void throwsException_whenListForMaxIsEmpty() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            umfangRechner.max(List.of());
        });

        assertEquals("List must not be empty or null.", exception.getMessage());
    }

    @Test
    void throwsException_whenListForMaxIsNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            umfangRechner.max(null);
        });

        assertEquals("List must not be empty or null.", exception.getMessage());
    }

    @Test
    void calculateMinUmfang() {
        double min = umfangRechner.min(forms);

        assertEquals(4.55, min);
    }

    @Test
    void throwsException_whenListForMinIsEmpty() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            umfangRechner.min(List.of());
        });

        assertEquals("List must not be empty or null.", exception.getMessage());
    }

    @Test
    void throwsException_whenListForMinIsNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            umfangRechner.min(null);
        });

        assertEquals("List must not be empty or null.", exception.getMessage());
    }

    @Test
    void calculateAvgUmfang() {
        double avg = umfangRechner.avg(forms);

        assertEquals(12.99159, avg, 0.00001);
    }

    @Test
    void throwsException_whenListForAvgIsEmpty() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            umfangRechner.avg(List.of());
        });

        assertEquals("List must not be empty or null.", exception.getMessage());
    }

    @Test
    void throwsException_whenListForAvgIsNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            umfangRechner.avg(null);
        });

        assertEquals("List must not be empty or null.", exception.getMessage());
    }
}