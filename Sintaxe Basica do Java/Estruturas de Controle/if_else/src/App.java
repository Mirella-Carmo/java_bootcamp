import java.util.Scanner;

public class  Main{
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.println("Informe o nome da pessoa:");
        var name = scanner.next();
        System.out.println("Informe a idade da pessoa:");
        var age = scanner.nextInt();
        System.out.println("Você é emancipado (s/n)");
        var isEmancipated = scanner.next().equalsIgnoreCase("s"); //o equal recebe o valor específico e o ignoreCase é para considerar maiúsculo e minúsculo

        if (age >= 18) System.out.printf("%s tem %s anos, pode dirigir\n", name, age);

        else if (age >= 16 && isEmancipated) {
            System.out.printf("%s, apesar de ter %s anos, você pode dirigir por ser emancipado\n", name,age);
        }
        else System.out.printf("%s, você não pode dirigir\n", name);

        //* USANDO Else operator
        var canDrive = (age >= 18) || (age >= 16 && isEmancipated);
        System.out.println(canDrive ? 
                name + ", você pode dirigir" :
                name + ", você não pode dirigir");
    }
}

//No lugar do else if, outra opção seria colocar idade >= 18 OU ser emancipado no if