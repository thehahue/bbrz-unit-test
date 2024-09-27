package at.bbrz.forms;

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
        forms = List.of(new Kreis(34), new Rechteck(72, 12), new Rechteck(1, 1) );
    }

    @Test
    void calculateSumOfList_forms() {
        double sum = flaechenRechner.sum(forms);
        assertEquals((34*34*Math.PI + 72*12 + 1*1),sum, 0.01);
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

        assertEquals(34*34*Math.PI, max, 0.01);
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
}