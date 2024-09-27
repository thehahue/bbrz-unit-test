package at.bbrz.rechner;

import at.bbrz.forms.Form;
import at.bbrz.forms.Kreis;
import at.bbrz.forms.Rechteck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UmfangRechnerTest {
    UmfangRechner umfangRechner;
    List<Form> forms = List.of(
            new Kreis(5),
            new Rechteck(4, 5),
            new Kreis(4.71));

    @BeforeEach
    void setUp() {
        umfangRechner = new UmfangRechner();
    }


    @Test
    void calculateSumOfUmfang() {
        double sum = umfangRechner.sum(forms);

        assertEquals(31.42 + 18 + 29.59, sum);
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

        assertEquals(31.42, max);
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

        assertEquals(18, min);
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

        assertEquals((31.42 + 18 + 29.59)/3, avg);
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

    @Test
    void sumRoundedCorrectly() {
        double sum = umfangRechner.sum(List.of(
                new Rechteck(5.000000001, 5)
        ));

        assertEquals(20, sum);
    }
}