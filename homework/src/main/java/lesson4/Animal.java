package lesson4;

class Animal {
    protected String name;
    static int animalCount = 0;

    Animal(String name) {
        this.name = name;
        animalCount++;
    }

    void run(int distance) {
        System.out.println(name + " пробежал " + distance + " м.");
    }

    void swim(int distance) {
        System.out.println(name + " проплыл " + distance + " м.");
    }

    static void printCount() {
        System.out.println("Всего животных: " + animalCount);
    }
}
