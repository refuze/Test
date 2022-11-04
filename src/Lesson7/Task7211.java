package Lesson7;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task7211 {
    public <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        stream.collect(Collectors.teeing(Collectors.maxBy(order), Collectors.minBy(order), (max, min) -> {
            minMaxConsumer.accept(min.orElse(null), max.orElse(null));
            return null;
        }));
    }

}
