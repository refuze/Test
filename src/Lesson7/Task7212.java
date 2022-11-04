package Lesson7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Task7212 {
    public static void main(String[] args) {
        Map<String, Integer> map = new TreeMap<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            reader.lines()
                    .forEach(x -> Arrays.stream(x.toLowerCase()
                    .replaceAll("(?U)[^\\p{L}\\p{Digit}]+", " ").split(" "))
                    .forEach(y -> map.merge(y, 1, Integer::sum)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(10)
                .forEach((x) -> System.out.println(x.getKey()));
    }

}
