package Lesson6;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Task6213 {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        Set<Integer> set2 = new TreeSet<>();
        set2.add(0);
        set2.add(1);
        set2.add(2);
        System.out.println(symmetricDifference(set, set2));
    }

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> result = new HashSet<>(set1);
        Set<T> hashSet = new HashSet<>(set1);

        result.addAll(set2);
        hashSet.retainAll(set2);
        result.removeAll(hashSet);

        return result;
    }

}
