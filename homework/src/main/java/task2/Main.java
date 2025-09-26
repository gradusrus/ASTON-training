package task2;

public class Main {
    public static void main(String[] args) {
        PhoneBook pb = new PhoneBook();
        pb.add("Иванов", "123-45-67");
        pb.add("Петров", "222-33-44");
        pb.add("Иванов", "555-66-77");

        System.out.println("Телефоны Иванова: " + pb.get("Иванов"));
        System.out.println("Телефоны Петрова: " + pb.get("Петров"));
        System.out.println("Телефоны Сидорова: " + pb.get("Сидоров"));
    }
}
