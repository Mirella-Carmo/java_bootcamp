
import java.time.OffsetDateTime;

public class Person {
    private final String name; //*declarar como final significa que a variável é uma constante
    private int age;

    //o ultimo ano que a idade foi incrementada:
    private int lastYearAgeInc = OffsetDateTime.now().getYear(); //retorna somente o ano atual (pega data e hora do sistema operacional)

    public Person(String name){ //*passando o parâmetro no CONSTRUTOR impedimos que ele seja alterado
        this.name = name;
        this.age = 1;
    }

    public String getName(){
        return this.name;
    }

    /*public void setName(String name){
        this.name = name;
    }*/

    public int getAge(){
        return this.age;
    }

    /*public void setAge(int age){
        this.age = age;
    }*/

    public void incAge(){
        if (this.lastYearAgeInc >= OffsetDateTime.now().getYear()) return;
        this.age +=1;
        this.lastYearAgeInc = OffsetDateTime.now().getYear();
    }
}
