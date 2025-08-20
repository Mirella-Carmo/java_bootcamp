public non-sealed class Manager extends User{
    public Manager(){
        this.isAdmin = true;
    }
    
    @Override
    public String consultSales() {
        return "Gerente não tem vendas próprias para consultar.";
    }

    public String consultSales(Seller seller) {
        return "Vendas do vendedor " + seller.getName() + ": " + seller.getSalesQuantity();
    }
}
