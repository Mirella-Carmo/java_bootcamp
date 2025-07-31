import java.util.Scanner;

public class Raiz_Potencia {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.println("Informe o primeiro valor:");
        var value1 = scanner.nextInt();

        //Raiz quadrada
        System.out.printf("A raiz quadrada de %s é %s\n", value1, Math.sqrt(value1));

        //Potencia
        System.out.printf("A potencia de %s elevado a 2 é %s", value1, Math.pow(value1, 2));
    }
}
