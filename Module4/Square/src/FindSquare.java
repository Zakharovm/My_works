
public class FindSquare {
    public static void main(String[] args) {
    Triangle n1 = new Triangle(5,6,7);
    Rectangle r1 = new Rectangle(10,20);
    Circle c1 = new Circle(15);


        System.out.println("The square of triangle is: " + new Calculation().findingT(n1));
        System.out.println("The square of rectangle is: " + new Calculation().findingR(r1));
        System.out.println("The square of circle is: " + new Calculation().findingC(c1));
    }

}
