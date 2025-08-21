
import br.com.dio.persistence.FilePersistence;
import br.com.dio.persistence.NIOFilePersistence;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException{
        FilePersistence persistence = new NIOFilePersistence("user.csv");
        System.out.println("===============");
        System.out.println(persistence.write("Ana;ana@ana.com;03/05/2005"));
        System.out.println("===============");
        System.out.println(persistence.write("Luana;luana@luana.com;04/05/2005"));
        System.out.println("===============");
        System.out.println(persistence.write("Ze;ze@ze.com;05/05/2005"));

        System.out.println("===============");
        System.out.println(persistence.findAll());

        System.out.println("===============");
        System.out.println(persistence.findBy(";luana@"));
        
        System.out.println("===============");
        System.out.println(persistence.remove("03/05"));
        System.out.println(persistence.findBy(";ana"));
        System.out.println(persistence.remove("laura")); //false
        
        System.out.println("===============");
        System.out.println(persistence.replace("Ze", "Joaquim;joca@joca.com;08/06/1970"));
    }
}
