package at.bbrz.rechner;

import at.bbrz.OutputWrapper;
import at.bbrz.forms.Kreis;
import at.bbrz.forms.Rechteck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class RechnerVisualOutputTest {
    
    RechnerVisualOutput rechnerVisualOutput;

    @Mock
    OutputWrapper outputWrapper;
    
    @BeforeEach
    void setUp() {
        rechnerVisualOutput = new RechnerVisualOutput(List.of(
                new Kreis(5),
                new Rechteck(4, 5),
                new Kreis(4.71)),
                outputWrapper);
    }

    @Test
    void printAllSummen() {
        rechnerVisualOutput.printAllSummen();
        Mockito.verify(outputWrapper).printLine("Umfangsummen: 79.01");
        Mockito.verify(outputWrapper).printLine("Flächensummen: 168.23");
    }
}