
import br.com.dio.persistence.FilePersistence;
import br.com.dio.persistence.IOFilePersistence;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException{
        FilePersistence persistence = new IOFilePersistence("user.csv");

        System.out.println("\n==============");
        System.out.println(persistence.write("Maria;maria@maria.com;dd/MM/yyyy;"));
        System.out.println("==============");
        System.out.println(persistence.write("João;joao@joao.com;dd/MM/yyyy;"));
        System.out.println("==============");
        System.out.println(persistence.write("Leo;leo@leo.com;dd/MM/yyyy;"));
        System.out.println("==============");
        System.out.println(persistence.write("Juca;juca@juca.com;dd/MM/yyyy;"));
        System.out.println("==============");

        System.out.println(persistence.findAll());
        System.out.println(persistence.findByID("leo"));

        System.out.println(persistence.remove("joao")); //retorna true se conseguir e false se não
        System.out.println(persistence.findByID("joao")); //não vai achar pq removeu

        System.out.println("=======replace=======");
        System.out.println(persistence.replace("@juca", "Carlos;carlos@carlos.com;05/05/2005"));
        System.out.println(persistence.findAll());
    }
}
