package Lesson6;

import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Task6215 {
    public static void main(String[] args) {
        Deque<Integer> result = new ArrayDeque<>();

        try (Scanner scanner = new Scanner(new InputStreamReader(System.in))) {
            String[] input = scanner.nextLine().split(" ");

            for (int i = 0; i < input.length; i++) {
                if (!(i % 2 == 0)) {
                    result.add(Integer.parseInt(input[i]));
                }
            }
        }

        while (!result.isEmpty()) {
            System.out.print(result.pollLast() + " ");
        }

    }
}
