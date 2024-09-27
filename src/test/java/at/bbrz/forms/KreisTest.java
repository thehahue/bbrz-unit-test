package at.bbrz.forms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KreisTest {
    Kreis kreis;

    @Test
    void caclulateFlaeche_andRoundWithTwoDecimalPlaces() {
        kreis = new Kreis(5);
        assertEquals(78.54, kreis.flaeche());

        kreis = new Kreis(4.71);
        assertEquals(69.69, kreis.flaeche());
    }

    @Test
    void caclulateUmfang_andRoundWithTwoDecimalPlaces() {
        kreis = new Kreis(5);
        assertEquals(31.42, kreis.umfang());

        kreis = new Kreis(4.71);
        assertEquals(29.59, kreis.umfang());
    }

    @Test
    void throwException_whenRadiusZeroOrNegative() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            kreis = new Kreis(0);
        });
        assertEquals("Radius must not be zero or negative.", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            kreis = new Kreis(-1);
        });
        assertEquals("Radius must not be zero or negative.", exception.getMessage());
    }

    @Test
    void throwExcption_whenFlaecheCalculationIsInfinite() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            kreis = new Kreis(Double.MAX_VALUE);
            kreis.flaeche();
        });
        assertEquals("Calculation overflow.", exception.getMessage());
    }

    @Test
    void throwExcption_whenUmfangCalculationIsInfinite() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            kreis = new Kreis(Double.MAX_VALUE);
            kreis.umfang();
        });
        assertEquals("Calculation overflow.", exception.getMessage());
    }
}