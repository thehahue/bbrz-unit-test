package at.bbrz.rechner;
import at.bbrz.OutputWrapper;
import at.bbrz.forms.Form;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class RechnerVisualOutput {
    private final OutputWrapper outputWrapper;
    private final List<Rechner> rechner;
    private final List<Form> formen;

    public RechnerVisualOutput(List<Form> formen, OutputWrapper outputWrapper) {
        rechner = List.of(new UmfangRechner(), new FlaechenRechner());
        this.formen = formen;
        this.outputWrapper = outputWrapper;
    }

    public void printAllSummen() {
        for (Rechner re : rechner){
            outputWrapper.printLine( re.getSummenText() + roundWithTwoDecimalPlaces(re.sum(formen)));
        }
    }
    private double roundWithTwoDecimalPlaces(double result) {
        BigDecimal bd = new BigDecimal(Double.toString(result));
        bd = bd.setScale(2, RoundingMode.HALF_UP);

        return bd.doubleValue();
    }

    public void printMin() {
        for (Rechner re : rechner) {
            outputWrapper.printLine( re.getMinText() + roundWithTwoDecimalPlaces(re.min(formen)));
        }
    }
}
