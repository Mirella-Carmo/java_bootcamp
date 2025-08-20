import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

public class App {
    public static void main(String[] args){
        Set<User> users = new HashSet<>(); //se quiser ordenação usa LinkedHashSet<>
        users.add(new User(1, "João"));
        users.add(new User(2, "Maria"));
        users.add(new User(3, "Fernando"));

        System.out.println(new User(1, "João").hashCode()); //vai aparecer o codigo
        System.out.println(users.contains(new User(1, "João")));
        users.forEach(System.out::println);

        //* Outra forma de acessar (com iterator)
        var iterator = users.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("=========");
        users.removeIf(user -> user.getId() > 1);
        users.removeIf(Predicate.not(user -> user.getId() > 2)); //NÃO remove o que são maiores que 2
        System.out.println(users);

    }
}
//Set não permite duplicidades na lista