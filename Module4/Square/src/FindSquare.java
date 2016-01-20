
public class FindSquare {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(5, 6, 7);
        Rectangle rectangle = new Rectangle(10, 20);
        Circle circle = new Circle(15);


        System.out.println("The square of triangle is: " + new Calculators().findTriangleSquare(triangle));
        System.out.println("The square of rectangle is: " + new Calculators().findRectangleSquare(rectangle));
        System.out.println("The square of circle is: " + new Calculators().findCircleSquare(circle));
    }

}
