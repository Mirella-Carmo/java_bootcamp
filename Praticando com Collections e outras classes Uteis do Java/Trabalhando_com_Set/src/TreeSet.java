import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

public class TreeSet {
    public static void main(String[] args){
        Set<User> users = new TreeSet<>(Users u1, Users u2) -> {
            var compareResult = 0;
            if (u1.id < u2.id) compareResult --;
            if (u1.id > u2.id) compareResult ++;
            return compareResult;
        }; 


    }
}
//Set não permite duplicidades na lista