public class Triangle {
    // площадь по формуле Герона
    public static double area(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) throw new IllegalArgumentException("Стороны должны быть > 0");
        if (a + b <= c || a + c <= b || b + c <= a) throw new IllegalArgumentException("Треугольник невозможен");

        double p = (a + b + c) / 2.0;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
