public non-sealed class Attendant extends User{
    private double cashInHand;

    public Attendant(){
        this.isAdmin = false;
    }

    public double getCashInHand() {
        return cashInHand;
    }

    public void setCashInHand(double cashInHand) {
        this.cashInHand = cashInHand;
    }
    @Override
    public String consultSales(){
        return "Usuário sem permissão para consultar vendas";
    }
}
