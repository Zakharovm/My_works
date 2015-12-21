public class Determination {

    /* вычисление расстояния */
    public double calculate(Point t1, Point t2) {
        double dx = t1.getX() - t2.getX();
        double dy = t1.getY() - t2.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

}
