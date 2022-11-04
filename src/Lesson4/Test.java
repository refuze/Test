package Lesson4;

public class Test {
    public static void main(String... args) {
        System.out.println(getNumber());
    }

    public static int getNumber() {
        try {
            return 10;
        } finally {
            return 11;
        }
    }

    public static class Car implements AutoCloseable {
        public void drive() {
            System.out.println("Машина поехала.");
        }

        @Override
        public void close() throws Exception {
            System.out.println("Машина закрывается...");
        }
    }
}
