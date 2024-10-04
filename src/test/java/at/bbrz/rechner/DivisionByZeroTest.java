package at.bbrz.rechner;

import at.bbrz.forms.Form;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class DivisionByZeroTest {


    FlaechenRechner flaechenRechner;
    UmfangRechner umfangRechner;
    List<Form> forms;

    @Mock
    Form form;

    @BeforeEach
    void setUp() {
        flaechenRechner = new FlaechenRechner();
        umfangRechner = new UmfangRechner();
        Mockito.when(form.flaeche()).thenThrow(new ArithmeticException("Division by zero not possible."));
        Mockito.when(form.umfang()).thenThrow(new ArithmeticException("Division by zero not possible."));
        forms = List.of(form);
    }

    @Test
    void throwsException_whenDivisionByZero() {
        Throwable exception = assertThrowsExactly(ArithmeticException.class, () -> {
            flaechenRechner.sum(forms);
        });

        assertEquals("Division by zero not possible.", exception.getMessage());

        exception = assertThrowsExactly(ArithmeticException.class, () -> {
            umfangRechner.sum(forms);
        });

        assertEquals("Division by zero not possible.", exception.getMessage());
    }
}
