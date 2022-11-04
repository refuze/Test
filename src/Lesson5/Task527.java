package Lesson5;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Task527 {
    public static void main(String[] args) {
        System.out.println(new Task527().sumOfStream(new ByteArrayInputStream(new byte[]{0, -9, 0, 5})));
    }

    public int sumOfStream(InputStream inputStream) {
        int counter = 0;

        try (inputStream) {
            int number;

            while ((number = inputStream.read()) != -1) {

                counter += (byte) number;
            }
        } catch (IOException e) {

        }
        return counter;
    }
}
