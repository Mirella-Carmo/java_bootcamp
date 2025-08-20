public record Circle(double radius) implements GeometryForm{
    private static final double pi = 3.14;
    @Override
    public double getArea(){
        return pi * (radius * radius);
    }
}
