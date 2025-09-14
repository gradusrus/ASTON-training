package lesson4;

public class Main {

    public static void main(String[] args) {

        Dog dog1 = new Dog("Шарик");
        dog1.run(300);
        dog1.swim(5);

        Cat cat1 = new Cat("Мурзик");
        cat1.run(250);
        cat1.swim(3);

        Animal.printCount();
        Dog.printCount();
        Cat.printCount();

        System.out.println("=== Кормим котов ===");

        Bowl bowl = new Bowl(20);
        Cat[] cats = {
                new Cat("Барсик"),
                new Cat("Пушок"),
                new Cat("Снежок")
        };

        for (Cat c : cats) {
            c.eat(bowl, 10);
        }

        for (Cat c : cats) {
            System.out.println(c.name + " сытость: " + (c.isFull() ? "сыт" : "голоден"));
        }

        bowl.addFood(30);
        cats[2].eat(bowl, 15);
        System.out.println(cats[2].name + " сытость: " + (cats[2].isFull() ? "сыт" : "голоден"));
    }
}

