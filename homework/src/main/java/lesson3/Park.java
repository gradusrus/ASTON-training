package lesson3;

class Park {

    class Attraction {
        String name;
        String workingHours;
        double price;

        Attraction(String name, String workingHours, double price) {
            this.name = name;
            this.workingHours = workingHours;
            this.price = price;
        }

        void printInfo() {
            System.out.println("Аттракцион: " + name);
            System.out.println("Время работы: " + workingHours);
            System.out.println("Цена: " + price + " руб.");
            System.out.println("");
        }
    }
}
