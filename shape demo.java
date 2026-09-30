import java.util.Scanner;

// 1. Define the Shape interface
interface Shape {
    double area();
    double perimeter();
}

// 2. Implement the Rectangle class
class Rectangle implements Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }

    @Override
    public double perimeter() {
        return 2 * (length + width);
    }
}

// 3. Implement the Triangle class
class Triangle implements Shape {
    private double side1;
    private double side2;
    private double side3;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public double perimeter() {
        return side1 + side2 + side3;
    }

    @Override
    public double area() {
        // Using Heron's Formula to find area using 3 sides
        double s = perimeter() / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }
}

// 4. Main class to handle user input and polymorphic array execution
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Creating an interface reference array of size 2
        Shape[] shapes = new Shape[2];

        System.out.println("--- Enter Rectangle Details ---");
        System.out.print("Enter length: ");
        double length = scanner.nextDouble();
        System.out.print("Enter width: ");
        double width = scanner.nextDouble();
        // Storing Rectangle object in the interface array
        shapes[0] = new Rectangle(length, width);

        System.out.println("\n--- Enter Triangle Details ---");
        System.out.print("Enter side 1: ");
        double s1 = scanner.nextDouble();
        System.out.print("Enter side 2: ");
        double s2 = scanner.nextDouble();
        System.out.print("Enter side 3: ");
        double s3 = scanner.nextDouble();
        // Storing Triangle object in the interface array
        shapes[1] = new Triangle(s1, s2, s3);

        // Iterating through the interface reference array to print results
        System.out.println("\n--- Calculated Results ---");
        for (int i = 0; i < shapes.length; i++) {
            System.out.println("Shape " + (i + 1) + " (" + shapes[i].getClass().getSimpleName() + "):");
            System.out.printf("  Area: %.2f\n", shapes[i].area());
            System.out.printf("  Perimeter: %.2f\n", shapes[i].perimeter());
        }

        scanner.close();
    }
}
