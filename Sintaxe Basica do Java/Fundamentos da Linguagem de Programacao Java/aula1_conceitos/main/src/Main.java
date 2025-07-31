import java.util.Scanner;

public class Main{
    private final static String WELCOME_MESSAGE = "Olá mundo"; //por ser privado nenhuma outra classe pode acessar, só essa. o final é como uma constante, o valor não pode ser alterado

    public static void main(String[] args) { //* essa linha é o ponto de entrada de qualquer aplicação Java
        Scanner scanner = new Scanner(System.in); //no lugar do primeiro Scanner pode usar var (pq por padrão já é String)
        System.out.println("Olá informe o seu nome: ");
        String name = scanner.next(); //para ler a linha inteira considerando os espaços    
        System.out.println("Olá informe o sua idade: ");
        int age = scanner.nextInt();
        System.out.println("Olá " + name + "sua idade é " + age);

        //Outra forma de concatenar:
        System.out.printf("Olá %s sua idade é %s \n", name, age);
    }
}

/*O Scanner em Java é uma classe fundamental usada para obter entrada de dados de várias fontes, principalmente do teclado (entrada padrão, System.in) ou de arquivos. */