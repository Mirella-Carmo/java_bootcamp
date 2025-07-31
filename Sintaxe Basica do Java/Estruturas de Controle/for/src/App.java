public class App {
    public static void main(String[] args){
        for (var i = 1; i <= 10; i++){
            if (i == 10){
                System.out.println("Fim da Execução");
                break; //é uma das formas, mas o <= 100 tbm interrompe ao chegar a 100
            }
            System.out.println(i);
        }

        //* Em ordem descrescente de 10 a 0
        System.out.println("DECRESCENTE");
        for (var i = 10; i >=0; i--){
            System.out.println(i);
        }

        //* Número par
        System.out.println("NÚMEROS PARES");
        for (var i = 2; i <= 10; i+=2){
            System.out.println(i);
        }
    }
}
