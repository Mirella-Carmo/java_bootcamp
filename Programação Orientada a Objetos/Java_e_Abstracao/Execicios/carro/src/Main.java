import java.util.Scanner;

public class Main {
    private final static Scanner scanner = new Scanner(System.in);
    private final static Car car = new Car();
    public static void main(String[] args){
        var option = -1;

        do { 
            System.out.println("====Escolha uma das opções=====");
            System.out.println("1 - Ligar o carro");
            System.out.println("2 - Desligar o carro");
            System.out.println("3 - Acelerar");
            System.out.println("4 - Diminuir Velocidade");
            System.out.println("5 - Virar para direita/esquerda");
            System.out.println("6 - Verificar velocidade");
            System.out.println("7 - Trocar marcha");
            System.out.println("0 - SAIR");
            option = scanner.nextInt();

            switch(option){
            case 1 -> car.turnOn();
            case 2 -> car.turnOff();
            case 3 -> car.speedUp();
            case 4 -> car.brake();
            case 5 -> turnLeftOrRight();
            case 6 -> car.checkSpeed();
            case 7 -> shiftCarGear();
            case 0 -> System.exit(0);
            default -> System.out.println("Inválido. Escolha uma das opções acima");
        }
        } while (option != 0);

    }
    public static void turnLeftOrRight(){
        var direction = "";
        while (direction == null || direction.isEmpty()){
            System.out.println("Informe o sentido: direita | esquerda");
            direction = scanner.next();
        }
        car.turnLeftAndRight(direction);
    }

    public static void shiftCarGear(){
        System.out.println("Informe a marcha de 1 a 6. A alteração deve ser sequencial");
        var gear = scanner.nextInt();
        car.shiftGear(gear);
    }
}
