package Lesson5;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        printDoubleSum();
    }

    static void printDoubleSum() {
        Scanner scanner = new Scanner(System.in);
        double sum = 0;
        while (scanner.hasNext()) {
            sum += scanner.nextDouble();
        }
        System.out.printf(Locale.ENGLISH, "%.6f", sum);
    }
}
