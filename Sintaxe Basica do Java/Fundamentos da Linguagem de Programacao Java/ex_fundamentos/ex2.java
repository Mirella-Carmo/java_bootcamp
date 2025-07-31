//Escreva um código que receba o tamanha do lado de um quadrado e calcule a sua área
import java.util.Scanner;

public class ex2 {
    public static void main(String[] args){
        var scanner = new Scanner(System.in);
        System.out.println("Informe comprimento de um lado do quadrado:");
        var length = scanner.nextFloat();
        var area = length * length;
        System.out.printf("O quadrado de lado %s tem comprimento %s", length, area);
    }
}
