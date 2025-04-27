package de.hska.iwi.ads.solution.interfaces;
import de.hska.iwi.ads.interfaces.AbstractCircle;
import de.hska.iwi.ads.interfaces.Vector;

public class Circle extends AbstractCircle{

    public Circle(Vector middlePoint, double radius) {
        super(middlePoint, radius);
    }

    public Circle(double radius) {
        super(radius);
    }

    public void scale(double factor) {
        if (factor <= 0.0) {
        }
        else { radius = radius * factor; }
    }

    public double area() {
        return radius*radius*Math.PI;
    }

    public double getDimension() {
        return  radius;
    }

}
