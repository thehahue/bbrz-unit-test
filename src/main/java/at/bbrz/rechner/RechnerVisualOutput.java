package at.bbrz.rechner;
import at.bbrz.OutputWrapper;
import at.bbrz.forms.Form;
import java.util.List;

public class RechnerVisualOutput {
    private OutputWrapper outputWrapper;
    private final List<Rechner> rechner;
    private final List<Form> formen;

    public RechnerVisualOutput(List<Form> formen, OutputWrapper outputWrapper) {
        rechner = List.of(new UmfangRechner(), new FlaechenRechner());
        this.formen = formen;
        this.outputWrapper = outputWrapper;
    }

    public void printAllSummen() {
        for (Rechner re : rechner) {
            outputWrapper.printLine( re.getRechnerName() + "summen: " + re.sum(formen));
        }
    }
}
