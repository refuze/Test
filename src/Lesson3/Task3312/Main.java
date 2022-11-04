package Lesson3.Task3312;

public class Main {
    public static void main(String[] args) {
        Human human1 = new Human();
        Human human2 = new Human(13, "Глеб", "Терещенко", "Хокей");
        Human human3 = new Human(13, "Глеб", "Терещенко");
    }


    public static class Human {
        int age;
        String name;
        String secondName;
        String favoriteSport;

        public Human() {

        }

        public Human(int age, String name, String secondName, String favoriteSport) {
            this(age, name, secondName);
            this.favoriteSport = favoriteSport;
        }

        public Human(int age, String name, String secondName) {
            this.age = age;
            this.name = name;
            this.secondName = secondName;
        }
    }
}
