package lesson4.shape;

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(5, "Красный", "Черный");
        Shape rectangle = new Rectangle(4, 6, "Синий", "Зеленый");
        Shape triangle = new Triangle(3, 4, 5, "Желтый", "Фиолетовый");

        System.out.println("|Круг|");
        circle.printInfo();
        ((ColoredShape)circle).printColors();

        System.out.println("|Прямоугольник|");
        rectangle.printInfo();
        ((ColoredShape)rectangle).printColors();

        System.out.println("|Треугольник|");
        triangle.printInfo();
        ((ColoredShape)triangle).printColors();
    }
}
