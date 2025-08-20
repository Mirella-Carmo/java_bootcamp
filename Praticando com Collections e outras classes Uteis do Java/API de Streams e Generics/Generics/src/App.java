import dao.GenericDAO;
import domain.UserDomain;
import dao.UserDAO;

public class App {
    public final static GenericDAO<UserDomain> dao = new UserDAO();
    
    public static void main(String[] args){
        var user = new UserDomain("João", 16);
        System.out.println(dao.count());
        System.out.println(dao.save(user));
        System.out.println(dao.findAll());
        System.out.println(dao.count());
        System.out.println(dao.delete(new UserDomain("", 7))); //false (não consegue achar)
        System.out.println(dao.findAll());
        System.out.println(dao.count());    
    }
    
}
