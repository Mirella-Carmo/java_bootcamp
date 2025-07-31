public class Main {
    public static void main(String[] args){
        var male = new Person("Joao");
        //male.setName("João");
        //male.setAge(21);
        male.incAge(); //só vai incrementar no próximo ano

        var female = new Person("Maria");
        //female.setName("Maria");
        //female.setAge(15);

        System.out.println("Nome masculino: " + male.getName() + " Idade: " + male.getAge());
        System.out.println("Nome feminino: " + female.getName() + " Idade: " + female.getAge());
    }
}
