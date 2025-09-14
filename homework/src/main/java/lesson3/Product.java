package lesson3;

class Product {
    String name;
    String productionDate;
    String manufacturer;
    String country;
    double price;
    boolean isReserved;

    Product(String name, String productionDate, String manufacturer, String country, double price, boolean isReserved) {
        this.name = name;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.country = country;
        this.price = price;
        this.isReserved = isReserved;
    }

    void printInfo() {
        System.out.println("Название: " + name);
        System.out.println("Дата производства: " + productionDate);
        System.out.println("Производитель: " + manufacturer);
        System.out.println("Страна: " + country);
        System.out.println("Цена: " + price);
        if (isReserved == true) {
            System.out.println("Забронирован: Да");
        } else System.out.println("Забронирован: Нет");
        System.out.println("");
    }
}
