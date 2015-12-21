public class Calculators {

    //  S = √p(p - a)(p - b)(p - c)     p=(a+b+c)/2     Формулы
    public double findTriangleSquare(Triangle triangle) {
        double p = (triangle.getSide1() + triangle.getSide2() + triangle.getSide3())/2;                      // находим полупериметр
        return Math.sqrt(p*(p-triangle.getSide1())*(p-triangle.getSide2())*(p-triangle.getSide3()));    // находим площадь
    }

    //S=a*b
    public double findRectangleSquare(Rectangle rectangle) {
        return rectangle.getSide1() * rectangle.getSide2();
    }

    // S=pi*r^2
    public double findCircleSquare(Circle circle) {
        return Math.PI*Math.pow(circle.getRadius(),2);
    }
}
