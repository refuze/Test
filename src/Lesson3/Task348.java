package Lesson3;

import java.math.BigInteger;
import java.util.Objects;

public class Task348 {
    public static class ComplexNumber {
        private double re;
        private double im;

        public ComplexNumber() {
        }

        public ComplexNumber(double re, double im) {
            this.re = re;
            this.im = im;
        }

        public double getRe() {
            return re;
        }

        public double getIm() {
            return im;
        }

        @Override
        public boolean equals(Object object) {
            if (this == object){
                return true;
            }
            if (object == null || getClass() != object.getClass()) {
                return false;
            }
            ComplexNumber complexNumber = (ComplexNumber) object;
            return Math.abs(Double.compare(getRe(), complexNumber.getRe())) == 0 &&
                    Math.abs(Double.compare(getIm(), complexNumber.getIm())) == 0;
        }

        @Override
        public int hashCode(){
            int result = 17;

            result = 37 * result + (int)(Double.doubleToLongBits(re) - (Double.doubleToLongBits(re) >>> 32));
            result = 37 * result + (int)(Double.doubleToLongBits(im) - (Double.doubleToLongBits(im) >>> 32));

            return result;
        }
    }
}
