public non-sealed class Salesman extends Employee{
    private double percentPerSold;
    private double soldAmount;

    public Salesman(String code,
                    String name, 
                    String address, 
                    int age, 
                    double salary,
                    double percentPerSold,
                    double soldAmount) {
        super(code, name, address, age, salary);
        this.percentPerSold = percentPerSold;
        this.soldAmount = soldAmount;
    }

    public Salesman() { //!implementação somente para funcionar a instancia new Manager na main
    super("", "", "", 0, 0.0); // chama o construtor da classe Employee
    this.percentPerSold = 0.0;
    this.soldAmount = 0.0;
}

    @Override //significa que vai sobrescrever algo
    public String getCode(){
        return "SL" + super.getCode();
    }

    @Override
    public double getFullSalary() {
        return this.salary + (soldAmount * percentPerSold)/100;
    }

    public double getPercentPerSold() {
        return percentPerSold;
    }

    public void setPercentPerSold(double percentPerSold) {
        this.percentPerSold = percentPerSold;
    }

    public double getSoldAmount() {
        return soldAmount;
    }

    public void setSoldAmount(double soldAmount) {
        this.soldAmount = soldAmount;
    }
}
