package at.bbrz;

import at.bbrz.forms.Form;

import java.util.ArrayList;
import java.util.List;

public class TestHelper {

    public static class TestForm implements Form{

        @Override
        public double flaeche() {
            return 1.111;
        }

        @Override
        public double umfang() {
            return 4.55;
        }
    }

    public static class TestFormWithParameters implements Form{

        private final double a;
        private final double b;

        public TestFormWithParameters(double a, double b){
            this.a = a;
            this.b = b;
        }

        @Override
        public double flaeche() {
            return a+b+2*a;
        }

        @Override
        public double umfang() {
            return b+a+a+a;
        }
    }

    public static class TestFormDivisionByZero implements Form {

        @Override
        public double flaeche() {
            return 10.0 / 0.0;
        }

        @Override
        public double umfang() {
            return -5.0 / 0.0;
        }
    }

    public static List<Form> createFormListWithThousandEntries(){

        List<Form> formList = new ArrayList<>();
        for (int i = 0; i < 1000; i++){
            formList.add(new TestFormWithParameters(0.1, 0.1));
        }
        return formList;
    }
}
