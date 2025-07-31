public class BankAccount {
    private double balance;
    private double overdraft = 0;

    public BankAccount(double balance){
        this.balance = balance;
    }

    public void checkBalance(){
        System.out.println("Saldo atual: R$" + this.balance);
    }

    public void checkoverdraft(){
        System.out.println("Cheque especial: R$" + this.overdraft);
    }
    
    //-----------funções extras
    private void chargeInterest(double value){ //*cobrar juros do valor usado do cheque especial
        var interest = value * 0.2;
        this.balance -= interest;
        System.out.println("Juros cobrado no valor de R$: " + interest + "\nDescontado da conta");
    }

    private double getOverdraftRemaining(){
        return this.balance + this.overdraft;
    }
    //------------

    public void depositMoney(double money){
        if (money > 0){
            this.balance += money;
            System.out.println("Depósito realizado no valor de: R$" + money +"\nNovo saldo: R$" + this.balance);
            if (money <=500){
                this.overdraft = 50;
            }
            else {
                this.overdraft = money * 0.5;
            }
        } else System.out.println("O valor do depósito precisa ser maior que 0");
    }

    public void withdrawMoney(double money){
        if (money < 0){
            System.out.println("O valor do saque precisa ser maior que 0");
            return;
        }
        if (money < this.balance){
            this.balance -= money;
        }
        else if (money > this.balance && money < getOverdraftRemaining()){
            double deficit = money - this.balance;
            this.balance = 0;
            this.chargeInterest(deficit);
        } else {
            System.out.println("Não foi possível realizar o saque de R$ " + money + ", pois excede seu limite de R$" + getOverdraftRemaining());
            return;
        }
        System.out.println("Saque realizado no valor de: R$" + money + "\nNovo saldo: R$" + this.balance);
    }

    public void payABill(double valueBill){
        if (valueBill < 0){
            System.out.println("O valor do boleto precisa ser maior que 0");
            return;
        }
        if (valueBill < this.balance){
            this.balance -= valueBill;
        }
        else if (valueBill > this.balance && valueBill < getOverdraftRemaining()){
            double deficit = valueBill - this.balance;
            this.balance = 0;
            this.chargeInterest(deficit);
        } else{
            System.out.println("Seu limite é R$" + getOverdraftRemaining() + " não foi possível pagar o boleto de R$" + valueBill);
            return;
        }
        System.out.println("Pagamento realizado com sucesso");

    }

    public void checkIfTheAccountIsUsingOverdraft(){
        if (getOverdraftRemaining() < this.overdraft){
            System.out.println("A conta usou o cheque especial");
        } else System.out.println("A conta NÃO usou o cheque especial");
    }
}
