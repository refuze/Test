package Lesson7;

public class Task719 {

    public interface NumberGenerator<T extends Number> {
        boolean cond(T arg);

        static NumberGenerator<? super Number> getGenerator() {
            return (x) -> x.intValue() > 0;
        }
    }
}
