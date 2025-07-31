import java.util.Scanner;

public class App {
    public static void main(String[] args){
        var scanner = new Scanner(System.in);
        var name = "";
        while (!name.equalsIgnoreCase("exit")){
            System.out.println("Informe um nome:");
            name  = scanner.next();
        }

        //outra forma obs: só roda depois que o primeiro while parar
        while (true) { 
            System.out.println("Informe um número positivo:");
            var num = scanner.nextInt();

            if (num < 0) break;
        }
    }
}

//* While -> primeiro verifica se a condição já foi atendida e depois executa
//* Do -> primeiro ele executa... depois ve se a condição foi atendida
