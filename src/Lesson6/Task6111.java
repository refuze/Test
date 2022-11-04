package Lesson6;

public class Task6111 {
    public static void main(String[] args) {
        System.out.println(Box.<String>getBox());
    }



    public static class Box<T> {
        private T object;

        public static <T> Box<T> getBox() {
            return new Box<>();
        }
    }

}
