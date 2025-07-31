import java.util.Scanner;

public class Drive {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.println("Qual a sua idade?");
        var age = scanner.nextInt();
        System.out.println("Você é emancipado?");
        var isEmancipated = scanner.nextBoolean(); //vai ler a entrada com booleano
        var canDrive = age >= 18 || (isEmancipated && age >=16); //parenteses é opcional, mas melhora a organização

        System.out.printf("Você pode dirigir? (%s) \n", canDrive);
    }
}

/*

| esse aqui é o OU burro que confere os dois valores
|| esse é o OU inteligente que confere apenas um, permitindo maior performance na aplicação
 */