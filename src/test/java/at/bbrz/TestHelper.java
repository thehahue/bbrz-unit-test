package at.bbrz;

import at.bbrz.forms.Form;

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

        private double a;
        private double b;

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
}
