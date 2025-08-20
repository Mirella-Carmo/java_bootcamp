import java.util.HashMap;
import java.util.Map;

import domain.User;


public class App {
    public static void main(String[] args){
        Map<String, User> users = new HashMap<>();
        users.put("joao@joao.com", new User("Joao", 22)); //o email é a chave e o usuário é o valor
        users.put("maria@maria.com", new User("Maria", 18));
        users.put("juca@juca.com", new User("Juca", 35));
        users.put("leo@leo.com", new User("Leo", 40));
        /*
        System.out.println(users);
        System.err.println("================");
        users.keySet().forEach(System.out::println);
        System.err.println("================");
        users.values().forEach(System.out::println);
        */
        System.out.println(users.containsKey("sergio@sergio.com")); //retorna true ou false
        System.out.println(users.containsValue(new User ("Leo", 40)));

        //*replace
        users.replace("maria@maria.com", new User("Maria", 50));// "repassa" substitui o valor
        users.forEach((k, v) -> System.out.printf("key: %s | value: %s\n", k, v));

        //*merge -> é uma forma mais elaborada de fazer o replace
        users.merge("joao@joao.com", new User("", 2), (user, user2) -> {
            System.out.println(user); //key: email
            System.out.println(user2); //value: obj nome idade
            return user2; //valor que substitui no map
        });

        //*putIfAbsent -> adiciona um novo valor se ele nao existir
        users.putIfAbsent("ana@julia", new User("Ana Julia", 34));
        System.out.println(users);
    }
}

//users.remove() retorna o metodo removido (se exibir no console) ou false se não encontrar
//TreeMap<>
//size() no Map retorna quantos pares chave–valor existem no mapa
