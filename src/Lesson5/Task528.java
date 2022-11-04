package Lesson5;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Task528 {
    public static void print(InputStream inputStream, OutputStream outputStream) throws IOException {
        int bytes;
        while ((bytes = inputStream.read()) != -1) {
            if ((byte) bytes % 2 == 0) {
                outputStream.write(bytes);
            }
        }
    }
}
