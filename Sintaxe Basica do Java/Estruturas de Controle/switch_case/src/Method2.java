import java.util.Scanner;

public class Method2 {
    public static void main (String[] args){
        var scanner = new Scanner(System.in);
        System.out.println("Informe um número de 1 a 7:");
        var option = scanner.nextInt();

        var message = switch (option){
            case 1,7 -> {
                var day = option == 1 ? "Domingo" : "Sábado";
                yield String.format("Hoje é %s, fim de semana uhuull", day); //yield diz o que vai retornar
            } 
            case 2 -> "Segunda";
            case 3 -> "Terça";
            case 4 -> "Quarta";
            case 5 -> "Quinta";
            case 6 -> "Sexta";
            //case 7 -> "Sábado");
            default -> "Opção Inválida";
        };
        System.out.println(message);
    }
}
