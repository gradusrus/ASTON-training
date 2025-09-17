package lesson4;

public class Main {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Шарик");
        dog1.run(300);
        dog1.swim(5);

        Cat cat1 = new Cat("Мурзик");
        cat1.run(150);
        cat1.swim(2);

        Animal.printCount();
        Dog.printCount();
        Cat.printCount();

        System.out.println("=== кормим (^_^) котов ===");

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

        bowl.addFood(25);
        cats[2].eat(bowl, 15);
        System.out.println(cats[2].name + " сытость: " + (cats[2].isFull() ? "сыт" : "голоден"));
    }
}

