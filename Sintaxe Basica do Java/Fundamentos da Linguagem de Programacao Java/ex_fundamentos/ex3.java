//Escreva um código que recebe a base e altura de um triângulo, calcule sua área e exiba

import java.util.Scanner;

public class ex3 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.println("Informe o valor da base:");
        var base = scanner.nextFloat();
        System.out.println("Informe o valor da altura:");
        var height = scanner.nextFloat();

        var area = (base * height)/2;
        System.out.printf("O triangulo de altura %s e base %s tem área %s\n", height, base, area);
    }
}
