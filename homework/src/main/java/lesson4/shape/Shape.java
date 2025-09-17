package lesson4.shape;

interface Shape {
    double getPerimeter();

    double getArea();

    default void printInfo() {
        System.out.println("Периметр " + getPerimeter());
        System.out.println("Площадь " + getArea());
    }
}
