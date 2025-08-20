import java.util.Scanner;

public class App {
    public static void main(String[] args){
        var scanner = new Scanner(System.in);
        var option = -1;
        while(option != 5){
            System.out.println("Escolha uma opção pelo número");
            System.out.println("1 - SOMA");
            System.out.println("2 - SUBTRAÇÃO");
            System.out.println("3 - MULTIPLICAÇÃO");
            System.out.println("4 - DIVISÃO");
            System.out.println("5 - SAIR");
            option = scanner.nextInt();

            if (option > 5 || option < 1){
                System.out.println("Escolha uma opção válida");
                continue;
            }
            if (option == 5){
                break; // ou System.exit(0)
            }
            var selectedOption = OperationEnum.values()[option - 1]; //o -1 é por causa do índice 0
            //var selectedOption_ = OperationEnum.valueOf("SUM"); //outra forma para pegar pelo nome

            System.out.println("Informe o primeiro valor:");
            var value1 = scanner.nextInt();
            System.out.println("Informe o segundo valor:");
            var value2 = scanner.nextInt();

            var result = selectedOption.getCalculate().apply(value1, value2);
            System.out.printf("%s %s %s = %s\n",value1, selectedOption.getSymbol(), value2, result);

        }
    }
}
