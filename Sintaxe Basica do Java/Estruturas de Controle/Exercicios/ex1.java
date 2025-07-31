//Escreva um código onde o usuário entra com um número e seja gerada a tabuada de 1 até 10 desse número
import java.util.Scanner;

public class ex1 {
    public static void main(String[] args){
        var scanner = new Scanner(System.in);
        System.out.println("Informe um número:");
        var number = scanner.nextInt();

        for (var i = 1; i <11; i++){
            var result = number * i;
            System.out.printf("%s x %s = %s\n", number, i, result);
        }
    }
}
