public class Calculation {
    public static void main(String[] args) {

        Point point1 = new Point(5, 10);
        Point point2 = new Point(2, 6);

        System.out.println("The distance between point A(" + point1.getX() + ";" + point1.getY() + ") and B(" + point2.getX() + ";" + point2.getY() + ") is : " + new Determination().calculateDistance(point1, point2));
    }

}
