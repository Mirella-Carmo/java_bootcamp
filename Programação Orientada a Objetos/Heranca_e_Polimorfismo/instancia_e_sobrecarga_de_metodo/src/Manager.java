public non-sealed class Manager extends Employee{
    private String login;
    private String password;
    private double commission;

    public Manager(String code, 
                String name, 
                String address, 
                int age, 
                double salary, 
                String login, 
                String password, 
                double commission) {
        super(code, name, address, age, salary);
    }

    public Manager() { //!implementação somente para funcionar a instancia new Manager na main
        super("", "", "", 0, 0.0); // chama o construtor da superclasse com valores genéricos
        this.login = "";
        this.password = "";
        this.commission = 0.0;
    }

    @Override //significa que vai sobrescrever algo
    public String getCode(){
        return "MN" + super.getCode();
    }

    @Override
    public double getFullSalary() {
        return this.salary + this.commission;
    }

    public double getFullSalary(double extra){ //sobrecarga de metodo
        return this.getFullSalary() + extra;
    }
    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public double getCommission() {
        return commission;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }
}
