package at.bbrz.rechner;

import at.bbrz.OutputWrapper;
import at.bbrz.forms.Form;
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
                new TestForm(),
                new TestFormWithParameters(2.1, 3.05)
        ),
                outputWrapper);
    }

    @Test
    void printAllSummen() {
        rechnerVisualOutput.printAllSummen();
        Mockito.verify(outputWrapper).printLine("Umfangsummen: 32.44");
        Mockito.verify(outputWrapper).printLine("Flächensummen: 26.58");
    }

    @Test
    void printAllMinValues(){
        rechnerVisualOutput.printMin();
        Mockito.verify(outputWrapper).printLine("Kleinster Umfang: 8.2");
        Mockito.verify(outputWrapper).printLine("Kleinste Fläche: 13.13");
    }

    private static class TestForm implements Form {

        @Override
        public double flaeche() {
            return 13.13;
        }

        @Override
        public double umfang() {
            return 24.24;
        }
    }

    private static class TestFormWithParameters implements Form {
        private final double a;
        private final double b;

        public TestFormWithParameters(double a, double b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public double flaeche() {
            return a * a * b;
        }

        @Override
        public double umfang() {
            return a + 2 * b;
        }
    }
}