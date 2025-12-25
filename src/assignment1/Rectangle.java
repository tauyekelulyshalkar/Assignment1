package assignment1;

public class Rectangle {

    // static variable (object counter)
    private static int count = 0;

    //(unique id)
    private int id;

    private double width;

    private double height;

    // Default constructor
    public Rectangle() {
        this.width = 1.0;
        this.height = 1.0;

        count++;
        this.id = count;
    }

    // Parameterized constructor
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;

        count++;
        this.id = count;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }

    //(object output)
    @Override //тексеру механизмі
    public String toString() {
        return "Rectangle{" +
                "id=" + id +
                ", width=" + width +
                ", height=" + height +
                ", area=" + getArea() +
                ", perimeter=" + getPerimeter() +
                '}';
    }
}
