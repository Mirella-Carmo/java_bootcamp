//Escreva um código que receba o nome e o ano de nascimento de alguém e retorne uma mensagem

import java.time.OffsetDateTime;
import java.util.Scanner;

public class ex1 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        System.out.println("Informe o seu nome:");
        var name = scanner.next();

        System.out.println("Informe a sua idade:");
        var age = scanner.nextInt();

        System.out.printf("Olá %s, você tem %s anos\n", name, age);

        //*Se quiser usar o ano de nascimento
        var baseYear = OffsetDateTime.now().getYear();

        System.out.println("Informe seu ano de nascimento:");
        var year = scanner.nextInt();

        System.out.printf("Olá %s, você tem %s anos\n", name, baseYear - year);

    }
}