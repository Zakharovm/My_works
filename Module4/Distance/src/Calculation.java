public class Calculation {
    public static void main(String[] args) {

        Point t1 = new Point(5, 10);
        Point t2 = new Point(2, 6);


        System.out.println("The distance between point A(" + t1.getX() +";" + t1.getY() + ") and B(" + t2.getX() +";" + t2.getY() + ") is : " + new Determination().calculate(t1, t2));
    }

}
