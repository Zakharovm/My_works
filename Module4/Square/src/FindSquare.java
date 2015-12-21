
public class FindSquare {
    public static void main(String[] args) {
    Triangle triangle = new Triangle(5,6,7);
    Rectangle rectangle = new Rectangle(10,20);
    Circle circle = new Circle(15);


        System.out.println("The square of triangle is: " + new Calculation().findTriangleSquare(triangle));
        System.out.println("The square of rectangle is: " + new Calculation().findRectangleSquare(rectangle));
        System.out.println("The square of circle is: " + new Calculation().findCircleSquare(circle));
    }

}
