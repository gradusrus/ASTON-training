package lesson4;

class Bowl {
    private int food;

    Bowl(int food) {
        this.food = food;
    }

    int getFood() {
        return food;
    }

    void decreaseFood(int amount) {
        if (food >= amount) {
            food -= amount;
        }
    }

    void addFood(int amount) {
        food += amount;
        System.out.println("В миску добавили " + amount + " еды. Теперь еды: " + food);
    }
}
