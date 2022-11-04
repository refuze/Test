package Lesson7;

import java.util.Random;
import java.util.stream.IntStream;

public class Task7210 {
    public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed, (n) -> (n * n)/10%1000);
    }
}
