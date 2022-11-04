package Lesson6;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task6214 {
    public static void main(String[] args) {

    }

    public static Map<String, Long> getSalesMap(Reader reader) throws IOException {
        Scanner scanner = new Scanner(reader);
        Map<String, Long> result = new HashMap<>();
        while (scanner.hasNext()) {
            result.merge(scanner.next(), scanner.nextLong(), ((v1, v2) -> v1 + v2));
        }

        return result;
    }

}
