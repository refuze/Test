package Lesson6;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class Test {
    public static void main(String[] args) {
        Collection<?> collection = new ArrayList<>();
        Object object = new Object();

        collection.remove(object);
        collection.toArray();

    }
}
