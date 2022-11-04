package Lesson6;

import java.util.Objects;

public class Task6113 {
    public static void main(String[] args) {
        Pair<Integer, String> pair = Pair.of(null, "hello");
        Integer i = pair.getFirst(); // 1
        System.out.println(i);
        String s = pair.getSecond(); // "hello"
        System.out.println(s);
        Pair<Integer, String> pair2 = Pair.of(null, "hello");
        boolean mustBeTrue = pair.equals(pair2); // true!
        System.out.println(mustBeTrue);
        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!
        System.out.println(mustAlsoBeTrue);
    }


    public static class Pair<T, G> {
        private final T first;
        private final G second;

        private Pair(T first, G second) {
            this.first = first;
            this.second = second;
        }

        public T getFirst() {
            return first;
        }

        public G getSecond() {
            return second;
        }

        public static <T, G> Pair<T, G> of(T t, G g) {
            return new Pair<>(t, g);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) o;

            return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }
    }

}
