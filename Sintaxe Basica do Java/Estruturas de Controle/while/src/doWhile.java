import java.util.Scanner;

public class doWhile {
    public static void main(String[] args){
        var scanner = new Scanner(System.in);

        do {
            System.out.println("Informe um nome:");
            var name = scanner.next();
            
            if (name.equalsIgnoreCase("exit")) break;
        }
        while (true);
    }
}
