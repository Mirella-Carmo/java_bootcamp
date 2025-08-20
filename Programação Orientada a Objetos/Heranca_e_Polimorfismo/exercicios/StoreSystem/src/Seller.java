public non-sealed class Seller extends User{
    private int salesQuantity;

    public Seller(){
        this.isAdmin = false;
    }

    public int getSalesQuantity() {
        return salesQuantity;
    }

    public void setSalesQuantity(int salesQuantity) {
        this.salesQuantity = salesQuantity;
    }

    public void sell(){
        this.salesQuantity++;
    }

    @Override
    public String consultSales(){
        return "Quantidade de Venda: " + this.salesQuantity;
    }
    
}
