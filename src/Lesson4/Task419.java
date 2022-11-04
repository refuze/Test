package Lesson4;

import java.io.IOException;
import java.util.Arrays;

public class Task419 {
    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());

        anotherMethod();
    }

    private static void anotherMethod() {
        System.out.println(getCallerClassAndMethodName());
    }

    public static String getCallerClassAndMethodName() {
        if (Thread.currentThread().getStackTrace().length > 3) {
            return Thread.currentThread().getStackTrace()[3].getClassName() + "#" + Thread.currentThread().getStackTrace()[3].getMethodName();
        } else {
            return null;
        }
    }
}
