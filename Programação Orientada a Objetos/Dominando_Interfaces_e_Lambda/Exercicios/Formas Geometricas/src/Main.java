import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in); //pq tem q ser static aq

    public static void main(String[] args){
        int option;
        GeometryForm geometryForm;
        while(true){
            System.out.println("Escolha um opção: ");
            System.out.println("1 - Quadrado");
            System.out.println("2 - Retângulo");
            System.out.println("3 - Círculo");
            System.out.println("4 - Sair");
            option = scanner.nextInt();
            if(option == 1){
                geometryForm = createSquare();
            } else if (option == 2){
                geometryForm = createRectangle();
            } else if(option == 3){
                geometryForm = createCircle();
            } else if(option == 4){
                break;
            } else {
                System.out.println("Valor inválido");
                continue;
            }
            System.out.println("O resultado do cálculo de área foi: "+ geometryForm.getArea());
        }
    }
    private static GeometryForm createSquare(){
        System.out.println("Informe o tamanho dos lados:");
        var side = scanner.nextDouble();
        return new Square(side); //?
    }
    private static GeometryForm createRectangle(){
        System.out.println("Informe o tamanho da base:");
        var base = scanner.nextDouble();
        System.out.println("Informe o tamanho da altura:");
        var height = scanner.nextDouble();
        return new Rectangle(base, height); //?
    }
    private static GeometryForm createCircle(){
        System.out.println("Informe o raio:");
        var radius = scanner.nextDouble();
        return new Circle(radius); //?
    }
}