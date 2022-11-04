package Lesson1;

public class DoubleExpression {
    public static void main(String[] args) {
        System.out.println(doubleExpression(4.5, 7.9, 12.4));
    }

    public static boolean doubleExpression(double a, double b, double c) {
        return Math.abs(a + b - c) < 0.0001;
    }

}
