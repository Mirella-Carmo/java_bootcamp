import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args){
        var value = "java;java;java;java";
        var values = value.split(";"); //quebra a string por algum delimitador
        //var values = value.split(""); //*se não passar nada ele quebra nas letras
        //var values = value.split(";", 2) //*tem um limite para quebrar (vai ate a segunda linha)

        for (var v : values){
            System.out.println(v);
        }

        value.toUpperCase(); //deixa maiúsculo
        value.toLowerCase(); //deixa minúsculo
        System.out.println(value.contains(";"));
        System.out.println(value.indexOf("a", 1, 5)); //achar o índice em que esta o "a" | procura apartir do ínidce 1 (inclusivo) | ate o índice 5 (exclusivo)

        var teste = "  ";
        var teste2 = " f ";
        System.out.println(teste.isBlank()); //* ve se a string ta vazia (desconsiderando espaço)
        System.out.println(teste2.trim()); //*desconsidera o espaço
        System.out.println(teste2.trim().repeat(5)); //repete a string

        System.out.println(value.substring(5,9)); //*extrai de um indice ate o outro

        var formatando = "%s";
        System.out.println(String.format(formatando, "Testando a formatação"));
    }
}

