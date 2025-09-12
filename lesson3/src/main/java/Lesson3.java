import java.sql.SQLOutput;

public class Lesson3 {
    public static void main(String[] args) {

        Product[] productsArray = new Product[5];

        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025", "Samsung Corp.", "Korea", 5599, true);
        productsArray[1] = new Product("iPhone 15", "10.03.2025", "Apple Inc.", "USA", 7499, false);
        productsArray[2] = new Product("Xiaomi Redmi Note 13", "05.01.2025", "Xiaomi", "China", 1999, true);
        productsArray[3] = new Product("Dell XPS 13", "20.12.2024", "Dell", "USA", 9999, false);
        productsArray[4] = new Product("Sony WH-1000XM5", "15.02.2025", "Sony", "Japan", 2499, true);

        for (int i = 0; i < productsArray.length; i++) {
            productsArray[i].printInfo();
        }

        Park park = new Park("FunPark");
        System.out.println("Название парка: " + park.namePark + "\n");
        park.printAttractions();
    }
}

class Product {
    String name;
    String productionDate;
    String manufacturer;
    String country;
    double price;
    boolean reserved;

    public Product(String name, String productionDate, String manufacturer, String country, double price, boolean reserved) {
        this.name = name;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.country = country;
        this.price = price;
        this.reserved = reserved;
    }

    void printInfo() {
        System.out.println("Название: " + name);
        System.out.println("Дата производства: " + productionDate);
        System.out.println("Производитель: " + manufacturer);
        System.out.println("Страна: " + country);
        System.out.println("Цена: " + price + " руб.");
        if (reserved == true) {
            System.out.println("Забронирован: Да");
        } else System.out.println("Забронирован: Нет");
        System.out.println("");
    }
}

class Park {
    String namePark;
    Attractions[] attractionsArray = new Attractions[5];

    public Park(String namePark) {
        this.namePark = namePark;

        attractionsArray[0] = new Attractions("Колесо обозрения", "10:00-18:00", 1000);
        attractionsArray[1] = new Attractions("Американские горки", "11:00-20:00", 1200);
        attractionsArray[2] = new Attractions("Дом с привидениями", "12:00-22:00", 800);
        attractionsArray[3] = new Attractions("Карусель", "09:00-19:00", 500);
        attractionsArray[4] = new Attractions("Водные горки", "10:00-18:00", 1500);
    }

    class Attractions {
        String nameAttraction;
        String workingHours;
        double priceAttraction;

        public Attractions(String nameAttraction, String workingHours, double priceAttraction) {
            this.nameAttraction = nameAttraction;
            this.workingHours = workingHours;
            this.priceAttraction = priceAttraction;
        }

        void printInfoAttraction() {
            System.out.println("Название: " + nameAttraction);
            System.out.println("Время работы: " + workingHours);
            System.out.println("Цена: " + priceAttraction + " руб.");
        }
    }

    public void printAttractions() {
        for (int i = 0; i < attractionsArray.length; i++) {
            attractionsArray[i].printInfoAttraction();
            System.out.println();
        }
    }
}