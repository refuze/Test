package Lesson6;

import java.util.Arrays;

public class Task6114 {
    public static void main(String[] args) {
        DynamicArray<Integer> dynamicArray = new DynamicArray<>();
        dynamicArray.add(1);
        dynamicArray.add(2);
        dynamicArray.add(3);
        dynamicArray.add(4);
        dynamicArray.add(5);
        System.out.println(dynamicArray);
        dynamicArray.remove(3);
        System.out.println(dynamicArray);
        dynamicArray.add(1);
        dynamicArray.add(2);
        dynamicArray.add(3);
        dynamicArray.add(4);
        dynamicArray.add(5);
        dynamicArray.add(1);
        dynamicArray.add(2);
        dynamicArray.add(3);
        dynamicArray.add(4);
        dynamicArray.add(5);
        dynamicArray.remove(3);
        dynamicArray.remove(3);
        dynamicArray.remove(3);
        System.out.println(dynamicArray);
        dynamicArray.remove(3);
        dynamicArray.remove(3);
        dynamicArray.remove(3);
        System.out.println(dynamicArray);
        dynamicArray.remove(3);
        dynamicArray.remove(3);
        dynamicArray.remove(3);
        System.out.println(dynamicArray);
        dynamicArray.remove(3);
        dynamicArray.remove(3);
        dynamicArray.remove(3);
        System.out.println(dynamicArray);
        dynamicArray.remove(3);
        dynamicArray.remove(3);
        dynamicArray.remove(3);
        System.out.println(dynamicArray);
    }

    public static class DynamicArray<T> {
        private Object[] dynamicArray = new Object[10];
        private int currentLength = 0;

        void add(T el) {
            if (currentLength == dynamicArray.length) {
                dynamicArray = Arrays.copyOf(dynamicArray, dynamicArray.length + 1);
            }
            dynamicArray[currentLength++] = el;
        }

        void remove(int index) {
            System.arraycopy(dynamicArray, index + 1, dynamicArray, index, dynamicArray.length - index - 1);
            dynamicArray = Arrays.copyOf(dynamicArray, dynamicArray.length - 1);
            currentLength--;
        }

        T get(int index) {
            return (T) dynamicArray[index];
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (Object el : dynamicArray) {
                sb.append((T) el).append(", ");
            }
            sb.delete(sb.length()-2, sb.length()-1);
            return sb.toString();
        }
    }
}
