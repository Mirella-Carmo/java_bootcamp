import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        List<User> users = new ArrayList<>();
        var user1 = new User(1, "João");
        users.add(user1);
        users.add(new User(2, "Maria"));
        users.add(new User(2, "Leo"));

        System.out.println(users.contains(user1)); //se tem o elemento
        System.out.println(users.size()); //o tamanho da lista
        System.out.println(users.isEmpty()); //se ta vazia
        /*
        System.out.println(users.getFirst());
        System.out.println(users.get(0));
        System.out.println(users.getLast());
        System.out.println(users.get(users.size() - 1)); */

        System.out.println(users.contains(new User(1, "João"))); //*vai funcionar porque sobrescrevemos o método para retornar true caso o nome fosse igual

        System.out.println(users); //vai aparecer na estrutura que sobrescrevemos no User

        //?remove: returna boolean se o valor foi removido ou não
        System.out.println(users.remove(new User(8, "sergio"))); //false 
        System.out.println(users.remove(0)); // retorna o elemento removido - também pode usar o removeFirst

    }
}
//! Se não tivesse sobrescrevido o método, não funcionaria porque ele verifica se o espaço na memória é igual. Como criamos um new User o espaço é diferente e retornaria false
