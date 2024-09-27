package at.bbrz.rechner;

import at.bbrz.forms.Kreis;
import at.bbrz.forms.Rechteck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class RechnerVisualOutputTest {
    
    private RechnerVisualOutput rechnerVisualOutput;
    
    @BeforeEach
    void setUp() {
        rechnerVisualOutput = new RechnerVisualOutput(List.of(
                new Kreis(5),
                new Rechteck(4, 5),
                new Kreis(4.71)));
    }

    @Test
    void printAllSummen() {
        rechnerVisualOutput.printAllSummen();
    }
}