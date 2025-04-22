public final class Triangle extends Figure {
    private double a;
    private double b;
    private double c;

    public Triangle(double x, double y, double a, double b, double c) {
        super(x, y);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    private double getSemiPerimeter() {
        return (a+b+c) / 2;
    }

    private boolean triangleExists() {
        return a + b > c && a + c > b && b + c > a;
    }

    @Override
    public double area() {
        if (triangleExists()) {
            double semiPerimeter = getSemiPerimeter();
            return Math.sqrt(semiPerimeter * (getSemiPerimeter() - a)
                    * (getSemiPerimeter() - b) * (getSemiPerimeter() - c));
        }
        return -1;
    }
}
