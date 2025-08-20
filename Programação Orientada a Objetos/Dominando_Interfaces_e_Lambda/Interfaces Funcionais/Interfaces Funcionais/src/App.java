import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class App {
    public static void main(String[] args){
        List<User> users = List.of(new User("Maria", 21), new User("João", 32), 
        new User ("Eduardo", 40), new User("Ana", 19)); //*List.of cria uma lista imutável

        printStringValue(Record::toString, users); //* o mesmo que: user -> user.toString()
    }
    private static void printStringValue(Function<User, String> callback, List<User> users){
        users.forEach(u -> System.out.println(callback.apply(u)));
    }
}

//? ao fazer new User() por ser um Record já gera automaticamente toString, equals, hashCode