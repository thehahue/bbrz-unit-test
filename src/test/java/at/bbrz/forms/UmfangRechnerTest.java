package at.bbrz.forms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
    void throwsException_whenListIsEmpty() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            umfangRechner.sum(List.of());
        });

        assertEquals("List must not be empty or null.", exception.getMessage());
    }

    @Test
    void throwsException_whenListIsNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            umfangRechner.sum(null);
        });

        assertEquals("List must not be empty or null.", exception.getMessage());
    }

}