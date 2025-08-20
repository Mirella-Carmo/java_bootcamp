public class Main {
    public static void main(String[] args){
        //Employee employee = new Employee(); //não funciona porque a classe é abstrata
        Employee manager = new Manager(); //classe gerente do tipo colaborador
        manager.setName("João");
        //manager.setPassword("1234"); //errado porque é um metodo de manager, não de employee

        System.out.println(manager.getName());
    }
}
