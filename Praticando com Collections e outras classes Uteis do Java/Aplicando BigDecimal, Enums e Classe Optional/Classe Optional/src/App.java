import static domain.SexEnum.FEMALE;
import static domain.SexEnum.MALE;
import java.util.Optional;
import domain.User;

public class App {
    public static void main(String[] args){
        Optional<User> optional = Optional.empty();
        //Optional.ofNullable(null); //aqui pode ser null
        System.out.println(optional.isEmpty());

        Optional<User> optional2 = Optional.of(new User("Joao", 27, MALE));
        
        //* Se estiver trabalhando com um valor que não sabe se será Nulo ou não, pode usar:
        Optional<User> optional3 = Optional.ofNullable(new User("Claudio", 7, MALE));
        optional2.ifPresent(System.out::println);
        optional3.ifPresentOrElse(user -> System.out.printf("Usuário: %s\n", user), 
                                () -> System.out.println("SEM USUÁRIO"));
        
        System.out.println(optional.orElse(new User("Maria", 5, FEMALE))); //se tiver valor, retorna optional, se não retorna MARIA (só aceita obj Optional)

        System.out.println(optional.orElse(defaultUser())); //defaultUser() sempre vai ser chamado antes de orElse decidir se precisa ou não. (recebe o objeto)
        System.out.println(optional.orElseGet(App::defaultUser)); //Avalia o que você passa somente se o Optional estiver vazio (recebe um Supplier que pode ser uma função ou method reference)


        //System.out.println(optional.get()); NÃO RECOMENDADO, se estiver vazio causa o erro NullPointException
    }
    public static User defaultUser(){
        System.out.println("Buscando valor default");
        return new User("Luna", 14, FEMALE);
    }
}

//NÃO pode usar Optional.of(null)
//* O VALOR DENTRO DO OPTIONAL é privado

/*
optional.ifPresent(valor -> System.out.println(valor)); igual o do código
optional.map(valor -> valor.toString()).orElse("Sem valor"); pode usar o method reference

OUTRA FORMA DE CRIAR
User user = optional.orElse(new User("Default", 0, MALE));
System.out.println(user);
 */