
import java.util.Scanner;

/*Escreva um código que o usuário entre com um primeiro número, um segundo número maior que o primeiro e escolha entre a opção par e ímpar, com isso o código deve informar todos os números pares ou ímpares (de acordo com a seleção inicial) no intervalo de números informados, incluindo os números informados e em ordem decrescente; */

public class ex3 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.println("Informe o primeiro número:");
        var num_min = scanner.nextInt();

        System.out.println("Informe o segundo número (deve ser maior que o 1°):");
        var num_max = scanner.nextInt();

        if (num_max > num_min){
            System.out.println("Escolha entre a opção par/impar:");
            var choice = scanner.next();

            for (var i = num_max; i >= num_min; i--){
                if (choice.equalsIgnoreCase("par") && i % 2 ==0){
                    System.out.println(i);

                } else if (choice.equalsIgnoreCase("impar") && i %2 !=0){
                    System.out.println(i);
                } 
            }
            } else System.out.println("Inválido. O segundo número deve ser maior que o primeiro");
        }
    }

