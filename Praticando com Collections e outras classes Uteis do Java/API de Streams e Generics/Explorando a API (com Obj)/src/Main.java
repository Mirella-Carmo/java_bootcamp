import domain.Contact;
import static domain.ContactType.EMAIL;
import static domain.ContactType.PHONE;
import static domain.Sex.FEMALE;
import static domain.Sex.MALE;
import domain.User;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<User> users = new ArrayList<>(generateUsers()); //*o ArrayList deixa a lista mutável, pq o generateUsers retorna um List.of que é imutável, e precisamos mexer na lista
        /*
        users.sort(Comparator.comparing(User::name)); //sort coloca os elementos em ordem
        é o mesmo que users.sort((u1, u2) -> u1.name().compareTo(u2.name()));
        */
        var values = users.stream().filter(u -> u.contacts().size() >= 2).toList(); //usuários com ao menos 2 contatos
        var withoutContact = users.stream().filter(u -> u.contacts() == null || u.contacts().isEmpty()).toList();

        var justEmail = users.stream().filter(u -> u.contacts().stream().allMatch(c -> c.type() == EMAIL)).toList(); //se não quiser NENHUM email troca para noneMatch      

        //*flatMap -> achata em um único stream de Contact, ao invés de ter vários streams dentro de um stream
        var contacts_list = users.stream()
            .flatMap(u -> u.contacts().stream())
            .filter(c -> c.type() == EMAIL)
            .sorted(Comparator.comparing(Contact::description)) //coloca ordem alfabetica os email
            .toList();

        System.out.println("Usuários com mais de 2 contatos");
        values.forEach(System.out::println);
        System.out.println("\nUsuários SEM contato");
        withoutContact.forEach(System.out::println);
        System.out.println("\nUsuários só com email");
        justEmail.forEach(System.out::println);
        System.out.println("\nContatos achatados com flatMap");
        contacts_list.forEach(System.out::println);
    }

    private static List<User> generateUsers() {
        var contacts1 = List.of(
            new Contact("(19)90665-8104", PHONE),
            new Contact("joao@gmail.com", EMAIL)
        );

        var contacts2 = List.of(
            new Contact("(21)92121-0032", PHONE)
        );

        var contacts3 = List.of(
            new Contact("lucas@outlook.com", EMAIL)
        );

        var contacts4 = List.of(
            new Contact("andreia@outlook.com", EMAIL),
            new Contact("andreia@gmail.com", EMAIL)
        );

        var contacts5 = List.of(
            new Contact("(31)97785-4456", PHONE),
            new Contact("(31)92115-0011", PHONE)
        );

        var user1 = new User("João", 26, MALE, new ArrayList<>(contacts1));
        var user2 = new User("Maria", 28, FEMALE, new ArrayList<>(contacts2));
        var user3 = new User("Lucas", 19, MALE, new ArrayList<>(contacts3));
        var user4 = new User("Andreia", 40, FEMALE, new ArrayList<>(contacts4));
        var user5 = new User("Vitor", 30, MALE, new ArrayList<>(contacts5));
        var user6 = new User("Bruna", 36, FEMALE, new ArrayList<>());

        return List.of(user1, user2, user3, user4, user5, user6);
    }
}
