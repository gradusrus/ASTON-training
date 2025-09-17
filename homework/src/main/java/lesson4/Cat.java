package lesson4;

class Cat extends Animal {
    static int catCount = 0;
    private boolean full = false; // сытость кота

    Cat(String name) {
        super(name);
        catCount++;
    }

    @Override
    void run(int distance) {
        if (distance <= 200) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не смог пробежать " + distance + " м.");
        }
    }

    @Override
    void swim(int distance) {
        System.out.println(name + " не умеет плавать!");
    }

    void eat(Bowl bowl, int foodAmount) {
        if (bowl.getFood() >= foodAmount) {
            bowl.decreaseFood(foodAmount);
            full = true;
            System.out.println(name + " поел и теперь сыт.");
        } else {
            System.out.println(name + " хотел поесть, но еды не хватило.");
        }
    }

    boolean isFull() {
        return full;
    }

    static void printCount() {
        System.out.println("Котов создано: " + catCount);
    }
}
