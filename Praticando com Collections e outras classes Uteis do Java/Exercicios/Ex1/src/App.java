import br.com.dio.calc.Operation;
import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args){
        var scanner = new Scanner(System.in);
        System.out.println("Informe o número das operações que deseja realizar (1 - SOMA, 2 - SUBTRAÇÃO)");
        var operationOption = scanner.nextInt();
        while (operationOption > 2 || operationOption < 1){
            System.out.println("Escolha uma opção válida");
            operationOption = scanner.nextInt();
        }

        var selectedOperation = Operation.values()[operationOption - 1]; //pq a contagem do enum começa no 0
        //*Operation.values() retorna um array com todas as constantes do enum (SUM e SUBTRACTION).
        
        System.out.println("Informe os números que serão utilizados separados por vírgula (ex: 1,2,3)");
        var numbers = scanner.next(); //é uma string por causa da vírgula
        var numberArray = Arrays.stream(numbers.split(","))
            .mapToLong(Long::parseLong)
            .toArray();

        var result = selectedOperation.getOperationCallback().exec(numberArray);
        var operationToShow = numbers.replaceAll(",", selectedOperation.getSignal());
        System.out.printf("O resultado da operação %s = %s\n", operationToShow, result);
    }
}
