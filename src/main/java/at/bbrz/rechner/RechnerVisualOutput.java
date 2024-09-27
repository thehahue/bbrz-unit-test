package at.bbrz.rechner;
import at.bbrz.forms.Form;
import java.util.List;

public class RechnerVisualOutput {
    private final List<Rechner> rechner;
    private final List<Form> formen;

    public RechnerVisualOutput(List<Form> formen) {
        rechner = List.of(new UmfangRechner(), new FlaechenRechner());
        this.formen = formen;
    }

    public void printAllSummen() {
        for (Rechner re : rechner) {
            System.out.println( re.getRechnerName() + "summen: " + re.sum(formen));
        }
    }
}
