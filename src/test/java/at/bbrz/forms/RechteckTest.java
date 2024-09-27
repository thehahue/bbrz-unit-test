package at.bbrz.forms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RechteckTest {
    private Rechteck rechteck;

    @Test
    void calculateCorrectFlaeche() {
        rechteck = new Rechteck(5,4);
        assertEquals(20, rechteck.flaeche());
    }

    @Test
    void calculateCorrectUmfang() {
        rechteck = new Rechteck(5,4);
        assertEquals(18, rechteck.umfang());
    }

    @Test
    void throwsException_whenFlaecheCalculationIsInfinite() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            rechteck = new Rechteck(Double.MAX_VALUE, Double.MAX_VALUE);
            rechteck.flaeche();
        });

        assertEquals("Calculation overflow.", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            rechteck = new Rechteck(Double.MAX_VALUE, 2);
            rechteck.flaeche();
        });

        assertEquals("Calculation overflow.", exception.getMessage());
    }

    @Test
    void throwsException_whenUmfangCalculationIsInfinite() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            rechteck = new Rechteck(Double.MAX_VALUE, Double.MAX_VALUE);
            rechteck.umfang();
        });

        assertEquals("Calculation overflow.", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            rechteck = new Rechteck(Double.MAX_VALUE, 2);
            rechteck.umfang();
        });

        assertEquals("Calculation overflow.", exception.getMessage());
    }

    @Test
    void throwsException_whenValuesAreNegative() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Rechteck(-5, -4);
        });

        assertEquals("Values must not be zero or negative.", exception.getMessage());
    }

    @Test
    void throwsException_whenValuesAreZero() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Rechteck(0, 0);
        });

        assertEquals("Values must not be zero or negative.", exception.getMessage());
    }

    @Test
    void throwsException_whenValuesAreZeroOrNegative() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Rechteck(-4, 0);
        });

        assertEquals("Values must not be zero or negative.", exception.getMessage());
    }
}