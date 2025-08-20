import static java.util.Objects.isNull;
import java.util.Objects;
import static java.util.Objects.hash;

public class User implements Comparable<User>{
    private int id;
    private String name;

    public User() {
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString(){
        return String.format("{'id': %s, 'name': %s}", id, name);
    }

    @Override
    public boolean equals(final Object obj){
        if (obj == this) return true;
        if ((isNull(obj)) || (!(obj instanceof User user))) return false;
        return this.id == user.getId() && Objects.equals(user.getName(), this.name); 
    }

    @Override
    public int hashCode(){ //para a alteração do equals funcionar, precisa desse hash
        return hash(this.id, this.name);
    }

    @Override
    //se o obj for igual, retorna 0. menor -1 e maior 1
    public int compareTo(final User that){ 
        var compareResult = 0;
        if (this.id < that.id) compareResult --;
        if (this.id > that.id) compareResult ++;
        return compareResult;
    }
}   

