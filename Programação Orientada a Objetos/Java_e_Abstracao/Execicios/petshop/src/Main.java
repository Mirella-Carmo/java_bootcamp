import java.util.Scanner;
//detalhes do exercicio no README
public class Main {

    private final static Scanner scanner = new Scanner(System.in);
    private final static PetMachine petMachine = new PetMachine();

    public static void main(String[] args){
        //scanner.useDelimiter("\\n");
        var option = -1;

        do {
            System.out.println("===Escolha um das opções===");
            System.out.println("1 - Dar banho no pet");
            System.out.println("2 - Abastecer a máquina com água");
            System.out.println("3 - Abastecer a máquina com shampoo");
            System.out.println("4 - verificar nivel de água");
            System.out.println("5 - verificar nivel de shampoo");
            System.out.println("6 - verificar se tem pet no banho");
            System.out.println("7 - colocar pet na maquina");
            System.out.println("8 - retirar pet da máquina");
            System.out.println("9 - limpar maquina");
            System.out.println("0 - SAIR");
            option = scanner.nextInt();

            switch(option){
                case 1 -> petMachine.takeAShower();
                case 2 -> setWater();
                case 3 -> setShampoo();
                case 4 -> verifyWater();
                case 5 -> verifyShampoo();
                case 6 -> checkIfHasPetInPetMachine();
                case 7 -> setPetInPetMachine();
                case 8 -> petMachine.removePet();
                case 9 -> petMachine.wash();
                case 0 -> System.exit(0);
                default-> System.out.println("Opção Inválida");
            }
        } while (option != 0);
    }

    //Caso 7: colocar o pet na maquina
    public static void setPetInPetMachine(){
        var name = "";
        while (name == null || name.isEmpty()){ //garantir que entre o nome do pet
            System.out.println("Informe o nome do pet: ");
            name = scanner.next();
        }
        var pet = new Pet(name);
        petMachine.setPet(pet);
    }

    //Caso 6: retornando mensagem de verificação
    public static void checkIfHasPetInPetMachine(){
        var hasPet = petMachine.hasPet();
        System.out.println(hasPet ? "Tem pet na máquina" : "Não há pet na máquina");
    }

    //Casos 5 e 4: retornando mensagem de verificação
    public  static void verifyShampoo(){
        var amount = petMachine.getShampoo();
        System.out.println("Nível de Shampoo da máquina: " + amount + " Litro(s)");
    } 

    public  static void verifyWater(){
        var amount = petMachine.getWater();
        System.out.println("Nível de água da máquina: " + amount + " Litro(s)");
    } 
    
    //Casos 3 e 2: retornando mensagem
    public static void setShampoo(){
        System.out.println("Abastecendo shampoo da máquina");
        petMachine.addShampoo();
    }

    public static void setWater(){
        System.out.println("Abastecendo água da máquina");
        petMachine.addWater();
    }
}


