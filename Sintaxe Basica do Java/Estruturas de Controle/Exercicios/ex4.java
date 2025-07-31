//Escreva um código onde o usuário informa um número inicial, posteriormente irá informar outros N números, a execução do código irá continuar até que o número informado dividido pelo primeiro número tenha resto diferente de 0 na divisão, números menores que o primeiro número devem ser ignorados

import java.util.Scanner;

public class ex4 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.println("Informe o número inicial:");
        var num1 = scanner.nextInt();

        do{
            System.out.println("Informe o próximo número");
            var nums = scanner.nextInt();
            if (nums < num1) {
                System.out.printf("Ignorado. %s menor que %s\n", nums, num1);
                continue; //para ignorar numeros menores que o primeiro
            }
            else if (nums % num1 != 0) {
                    System.out.println("Encerrado. Resto diferente de 0");
                    break;
                }

        }while(true);
    }
}

//* Outra forma de ignorar os números menores era fazer if (nums < num) continue