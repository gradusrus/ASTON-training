package lesson4.shape;

abstract class ColoredShape implements Shape {
    protected String fillColor;
    protected String borderColor;

    public ColoredShape(String fillColor, String borderColor) {
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    public void printColors() {
        System.out.println("Заливка " + fillColor);
        System.out.println("Граница " + borderColor);
    }
}
