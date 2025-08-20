public class Main {
    public static void main(String[] args) {
        printEmployee(new Manager());
        printEmployee(new Salesman());
    }
    public static void printEmployee(Employee employee){ //espera qualquer objeto que herde de employee
        System.out.printf("=======%s=======\n", employee.getClass().getCanonicalName());
        /*
        if (employee instanceof Manager manager){ //Se o objeto employee for uma instância da classe Manager, então crie uma variável chamada manager do tipo Manager e já faz o casting automaticamente
          employee.setName("João");
            manager.setLogin("joao123");
            manager.setPassword("12345");

            System.out.println(employee.getName());
            System.out.println(manager.getLogin());
            System.out.println(manager.getPassword());  
        } //Esse novo método do Java16 evita ter que fazer o casting manual: Manager manager = (Manager) employee;
        */
        switch(employee){ //*Só permite trabalhar SEM o default se a classe for sealed
            case Manager manager ->{
                manager.setCode("123");
                manager.setName("João");
                manager.setSalary(5000);
                manager.setLogin("joao123");
                manager.setPassword("12345");
                manager.setCommission(1200);

                System.out.println(manager.getCode());
                System.out.println(manager.getName());
                System.out.println(manager.getSalary());
                System.out.println(manager.getLogin());
                System.out.println(manager.getPassword());
                System.out.println(manager.getCommission());
                System.out.println(manager.getFullSalary(500));
            }
            case Salesman salesman ->{
                salesman.setCode("124");
                salesman.setName("Sergio");
                salesman.setSalary(2000);
                salesman.setPercentPerSold(10);
                salesman.setSoldAmount(1000);

                System.out.println(salesman.getCode());
                System.out.println(salesman.getName());
                System.out.println(salesman.getSalary());
                System.out.println(salesman.getPercentPerSold());
                System.out.println(salesman.getSoldAmount());
            }
        }
        System.out.println(employee.getFullSalary());
        System.out.println("=================");
    }
}
