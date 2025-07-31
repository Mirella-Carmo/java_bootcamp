/*
Escreva um código onde o usuário entra com sua altura e peso, seja feito o cálculo do seu IMC 
(IMC = peso / (altura * altura)) e seja exibida a mensagem de acordo com o resultado:

Se for menor ou igual a 18,5 → "Abaixo do peso";

Se for entre 18,6 e 24,9 → "Peso ideal";

Se for entre 25,0 e 29,9 → "Levemente acima do peso";

Se for entre 30,0 e 34,9 → "Obesidade Grau I";

Se for entre 35,0 e 39,9 → "Obesidade Grau II (Severa)";

Se for maior ou igual a 40,0 → "Obesidade III (Mórbida)";
 */

import java.util.Scanner;

public class ex2 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.println("Informe sua altura:");
        var height = scanner.nextFloat();
        System.out.println("Informe seu peso:");
        var weight = scanner.nextFloat();
        var imc = weight / (height * height);

        if (imc <= 18.5) System.out.println("Abaixo do peso");
        else if (imc >= 18.6 && imc <=24.9) System.out.println("Peso ideal");
        else if (imc >= 25 && imc <= 29.9) System.out.println("Levemente acima do peso");
        else if (imc >= 30 && imc <= 34.9) System.out.println("Obesidade grau I");
        else if (imc >= 35 && imc <= 39.9) System.out.println("Obesidade grau II (Severa)");
        else if (imc >= 40) System.out.println("Obesidade grau III (Mórbida)");
        else System.out.println("Inválido");

        System.out.printf("Seu IMC é %s", imc);

    }
}
