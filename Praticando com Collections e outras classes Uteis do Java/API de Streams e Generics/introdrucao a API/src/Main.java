import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        // Lista para guardar os valores espiados pelo peek
        List<String> debugValues = new ArrayList<>();

        var value = Stream.of("Maria", "João", "Marcio", "Luana", "Leandro", "Marcia")
                .peek(debugValues::add)                  // adiciona cada elemento em debugValues
                .filter(name -> name.endsWith("o")) // filtra nomes que terminam com "o"
                //.toList()                               // coleta resultado em lista
                //.anyMatch(n -> n.contains("a")) //ve se tem alguma ocorrencia da letra a
                .noneMatch(n -> n.contains("z")); //NÃO TEM letra z

        System.out.println(debugValues);

        System.out.println(value);

        var value2 = Stream.of(1,2,3,4,5,6,7,7,8,5,9)
            .distinct().toList(); //remove valores duplicados
        System.out.println(value2);
    }
}
