public record Square(double side) implements GeometryForm {
    @Override
    public double getArea() {
        return side * side;
    }
    

}
