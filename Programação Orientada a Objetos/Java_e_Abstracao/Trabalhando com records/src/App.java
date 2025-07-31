public class App {
    public static void main(String[] args){
        var person = new Person("João", 16);
        System.out.println(person);
        System.out.println(person.name());

        //tem como reaproveitar um atributo em outra instancia
        var newPerson = new Person(person.name(), 19);
        System.out.println(person.name() + " " + newPerson.age() + " anos");
    }
}
