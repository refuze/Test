package Lesson4;

public class Task418 {
    public void testExp() throws MyNewException {
        throw new MyNewException();
    }

    public class MyNewException extends Exception {
        public MyNewException() {
            super();
        }

        public MyNewException(String message) {
            super(message);
        }

        public MyNewException(String message, Throwable cause) {
            super(message, cause);
        }
    }


}
