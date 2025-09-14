package lesson3;

    public class Main {
        public static void main(String[] args) {
            Product[] productsArray = new Product[5];

            productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025", "Samsung Corp.", "Korea", 5599, true);
            productsArray[1] = new Product("iPhone 16 Pro", "10.09.2024", "Apple Inc.", "USA", 6999, false);
            productsArray[2] = new Product("Xiaomi 15", "15.11.2024", "Xiaomi Tech", "China", 2999, true);
            productsArray[3] = new Product("Sony PlayStation 6", "20.12.2024", "Sony Corp.", "Japan", 4999, false);
            productsArray[4] = new Product("LG OLED TV", "05.03.2025", "LG Electronics", "Korea", 7999, true);

            for (int i = 0; i < productsArray.length; i++) {
                productsArray[i].printInfo();
            }

            Park park = new Park();
            Park.Attraction a1 = park.new Attraction("Американские горки", "10:00 - 20:00", 350);
            Park.Attraction a2 = park.new Attraction("Колесо обозрения", "09:00 - 22:00", 200);
            Park.Attraction a3 = park.new Attraction("Комната страха", "12:00 - 23:00", 300);

            a1.printInfo();
            a2.printInfo();
            a3.printInfo();
        }
    }

