import br.com.dio.dao.UserDAO;
import br.com.dio.exception.EmptyStorageException;
import br.com.dio.exception.UserNotFoundException;
import br.com.dio.exception.ValidatorException;
import br.com.dio.model.MenuOption;
import br.com.dio.model.UserModel;
import static br.com.dio.validator.UserValidator.verifyModel;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class App {
    private static final Scanner scanner = new Scanner(System.in);

    private static final UserDAO dao = new UserDAO();
    public static void main(String[] args){
        while(true){
            System.out.println("\nBem vindo ao cadastro de usuários, selecione a opção desejada");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Exluir");
            System.out.println("4 - Buscar por Identificador");
            System.out.println("5 - Listar");
            System.out.println("6 - Sair");

            var userInput = scanner.nextInt();
            var selectedOption = MenuOption.values()[userInput -1];
            switch(selectedOption){
                case SAVE -> {
                    try {
                        var user = dao.save(requestToSave());
                        System.out.printf("Usuário Cadastrado %s\n", user);
                    } catch (ValidatorException ex){ //!depois, adicionar um while true nessa tratativa
                        System.out.println(ex.getMessage());
                        ex.printStackTrace();
                    } 
                    
                }
                case UPDATE -> {
                    try {
                        var user = dao.save(requestToUpdate());
                        System.out.printf("Usuário atualizado %s\n", user);
                    } catch (UserNotFoundException | EmptyStorageException ex){ 
                        System.out.println(ex.getMessage());
                    } catch (ValidatorException ex){
                        System.out.println(ex.getMessage());
                        ex.printStackTrace();
                    }
                }
                case DELETE -> {
                    try {
                        dao.delete(requestId());
                        System.out.println("Usuário excluído");
                    } catch (UserNotFoundException | EmptyStorageException ex){ 
                        System.out.println(ex.getMessage());
                    } finally{ //*esse bloco sempre é executado
                        System.out.println("================");
                    }
                }
                case FIND_BY_ID -> {
                    try {
                        var id = requestId();
                        var user = dao.findById(id);
                        System.out.printf("Usuário com id %s", id);
                        System.out.println(user);
                    } catch (UserNotFoundException | EmptyStorageException ex){ //se o tratamento não for o mesmo pode usar blocos catch separados
                        System.out.println(ex.getMessage());
                    }
                    
                }
                case FIND_ALL -> {
                    var users = dao.findAll();
                    System.out.println("Usuários Cadastrados:");
                    System.out.println("================");
                    users.forEach(System.out::println);
                    System.out.println("=======FIM========");
                }
                case EXIT -> System.exit(0);
            }
        }
    }

    public static long requestId(){
        System.out.println("Informe o identificador do usuário");
        return scanner.nextLong();
    }

    public static UserModel requestToSave() throws ValidatorException{
        System.out.println("Informe o nome do usuário");
        var name = scanner.next();

        System.out.println("Informe o e-mail do usuário");
        var email = scanner.next();

        System.out.println("Informe a data de nascimento do usuário (dd/MM/yyyy)");
        var birthdayString = scanner.next();
        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        var birthday = LocalDate.parse(birthdayString, formatter);

        return validateInputs(0, name, email, birthday);
    }

    private static UserModel validateInputs(final long id, final String name, 
                            final String email, final LocalDate birthday) throws ValidatorException {
        var user = new UserModel(0, email, name, birthday);
        verifyModel(user);
        return user;
    }

    public static UserModel requestToUpdate() throws ValidatorException{
        System.out.println("Informe o identificador do usuário");
        var id = scanner.nextLong();

        System.out.println("Informe o nome do usuário");
        var name = scanner.next();

        System.out.println("Informe o e-mail do usuário");
        var email = scanner.next();

        System.out.println("Informe a data de nascimento do usuário (dd/MM/yyyy)");
        var birthdayString = scanner.next();
        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        var birthday = LocalDate.parse(birthdayString, formatter);

        return validateInputs(0, name, email, birthday);
    }
}
