import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        var scanner = new Scanner(System.in);
        System.out.println("Informe o primeiro valor:");
        var valor1 = scanner.nextFloat();
        System.out.println("Informe o segundo valor:");
        var valor2 = scanner.nextFloat();

        System.out.printf("%s / %s = %s\n", valor1, valor2, valor1 / valor2); //divisao

        //Resto também é % no Java e como está dentro da formatação, deve adicionar %% duplicado
        System.out.printf("%s %% %s = %s\n", valor1, valor2, valor1 % valor2);

        scanner.close();
    }
}
