package Lesson3.Task3311;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.sayHello();

        Dog dog = new Dog();
        dog.sayHello();

        dog.catchCat(cat);
    }

    public static class Cat {
        public void sayHello() {
            System.out.println("Мяу!");
        }
    }

    public static class Dog {
        public void sayHello() {
            System.out.println("Гав!");
        }

        public void catchCat(Cat cat) {
            System.out.println("Кошка поймана");
            sayHello();
            cat.sayHello();
        }
    }

}
