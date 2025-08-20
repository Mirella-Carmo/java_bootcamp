public record Rectangle(double base, double height) implements GeometryForm {

    @Override
    public double getArea() {
        return base * height;
    }

}
