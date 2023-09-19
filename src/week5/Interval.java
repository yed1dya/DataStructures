package week5;

public class Interval {
    protected double a, b, length;

    public Interval(double a, double b) {
        this.a = Math.max(a, b);
        this.b = Math.min(a, b);
        this.length = this.a - this.b;
    }
}
