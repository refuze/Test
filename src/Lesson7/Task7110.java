package Lesson7;

import java.util.function.Function;
import java.util.function.Predicate;

public class Task7110 {
    public static <T, U> Function<T, U> ternaryOperator(Predicate<? super T> condition,
                                                        Function<? super T, ? extends U> ifTrue,
                                                        Function<? super T, ? extends U> ifFalse) {
        return (t) -> condition.test(t) ? ifTrue.apply(t) : ifFalse.apply(t);
    }

}
