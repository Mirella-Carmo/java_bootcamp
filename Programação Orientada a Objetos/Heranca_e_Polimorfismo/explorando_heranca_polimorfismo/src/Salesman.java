public class Salesman extends Employee{
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

    public String getCode(){
        return "SL" + super.getCode();
    }

    public double getFullSalary() {
        return this.salary + (soldAmount * percentPerSold)/100;
    }

    public double getFullSalary(double extra){ //* A sobrecarga de metodos também pode receber mais de um arg
        return getFullSalary() + extra;
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
