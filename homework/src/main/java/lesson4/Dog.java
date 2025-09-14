package lesson4;

class Dog extends Animal {
    static int dogCount = 0;

    Dog(String name) {
        super(name);
        dogCount++;
    }

    @Override
    void run(int distance) {
        if (distance <= 500) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не смог пробежать " + distance + " м.");
        }
    }

    @Override
    void swim(int distance) {
        if (distance <= 10) {
            System.out.println(name + " проплыл " + distance + " м.");
        } else {
            System.out.println(name + " не смог проплыть " + distance + " м.");
        }
    }

    static void printCount() {
        System.out.println("Собак создано: " + dogCount);
    }
}
