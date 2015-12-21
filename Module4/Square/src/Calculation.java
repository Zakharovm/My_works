

public class Calculation {

    //  S = √p(p - a)(p - b)(p - c)     p=(a+b+c)/2     Формулы
    public double findingT(Triangle t) {
        double p = (t.getA() + t.getB() + t.getC())/2;                      // находим полупериметр
        double s1 = Math.sqrt(p*(p-t.getA())*(p-t.getB())*(p-t.getC()));    // находим площадь
        return s1;
    }

    //S=a*b
    public double findingR(Rectangle r) {
        double s2 = (r.getA() * r.getB());
        return s2;
    }

    // S=pi*r^2
    public double findingC(Circle c) {
        double s3=Math.PI*Math.pow(c.getR(),2);
        return s3;
    }
}
