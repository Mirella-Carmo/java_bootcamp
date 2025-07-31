
import java.util.Scanner;

//Escreva um código que recebe o nome e idade de duas pessoas e retorne a diferença de idade
public class  ex4{
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.println("Informe o nome da primeira pessoa:");
        var name1 = scanner.next();
        System.out.println("Informe a idade da primeira pessoa:");
        var age1 = scanner.nextInt();

        System.out.println("Informe o nome da segunda pessoa:");
        var name2 = scanner.next();
        System.out.println("Informe a idade da segunda pessoa:");
        var age2 = scanner.nextInt();

        var difference = Math.abs(age1 - age2); //Math.abs retorna sempre um número positivo
        System.out.printf("A diferença de idade entre %s e %s é %s", name1, name2, difference);

    
    }
}