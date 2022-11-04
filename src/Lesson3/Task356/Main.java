package Lesson3.Task356;

import java.util.Arrays;

public class Main {
    public static class AsciiCharSequence implements CharSequence{
        private final byte[] bytes;

        public AsciiCharSequence(byte[] bytes) {
            this.bytes = bytes;
        }

        @Override
        public int length() {
            return bytes.length;
        }

        @Override
        public char charAt(int index) {
            return (char) bytes[index];
        }

        @Override
        public CharSequence subSequence(int start, int end) {
            return new AsciiCharSequence(java.util.Arrays.copyOfRange(bytes, start, end));
        }

        @Override
        public String toString() {
            return new String(bytes);
        }
    }

}
