import java.util.Scanner;

public class Main {
    private final static Scanner scanner = new Scanner(System.in);
    private static BankAccount bankAccount;

    public static void main(String[] args){
        System.out.println("Informe o valor inicial da conta:");
        double initialBalance = scanner.nextDouble();
        bankAccount = new BankAccount(initialBalance);
        
        var option = -1;
        do {
            System.err.println("\n=== Escolha uma das opções ===");
            System.out.println("1 - Consultar Saldo");
            System.out.println("2 - Consultar Cheque Especial");
            System.out.println("3 - Depositar Dinheiro");
            System.out.println("4 - Sacar Dinheiro");
            System.out.println("5 - Pagar um boleto");
            System.out.println("6 - Verificar se a conta está usando cheque especial");
            System.err.println("0 - Sair");

            option = scanner.nextInt();

            switch(option){
                case 1 -> bankAccount.checkBalance();
                case 2 -> bankAccount.checkoverdraft();
                case 3 -> depositMoney();
                case 4 -> withdrawMoney();
                case 5 -> payBill();
                case 6 -> bankAccount.checkIfTheAccountIsUsingOverdraft();
                case 0 -> System.exit(0);
                default -> System.out.println("Opção Inválida");
            }
        } while (option != 0);
    }

    public static void depositMoney(){
        System.out.println("Informe o valor do depósito: R$");
        double deposit = scanner.nextDouble();
        bankAccount.depositMoney(deposit);
    }

    public static void withdrawMoney(){
        System.out.println("Informe o valor do saque: R$");
        double amount = scanner.nextDouble();
        bankAccount.withdrawMoney(amount);
    }

    public static void payBill(){
        System.err.println("Informe o valor do boleto");
        double valueBill = scanner.nextDouble();
        bankAccount.payABill(valueBill);
    }
}
