package lesson4;

abstract class Animal {
    protected String name;
    static int animalCount = 0;

    Animal(String name) {
        this.name = name;
        animalCount++;
    }

    abstract void run(int distance);

    abstract void swim(int distance);

    static void printCount() {
        System.out.println("Всего животных: " + animalCount);
    }
}
